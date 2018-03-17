package cn.huashantech.liaoliao2.test.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import java.util.List;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.aidl.Book;
import cn.huashantech.liaoliao2.aidl.IBookManager;
import cn.huashantech.liaoliao2.aidl.IOnNewBookArrivedListener;
import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2018/3/16.
 * emails: qindingkang@huashantech.cn
 */

public class MainActivity extends Activity {

    public static final String TAG="MainActivity";
    private Intent intent;
    private IBookManager mRemoteBookManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_main);
        LogUtil.e("MainActivity","进入了MainActivity");
        Button button=(Button) findViewById(R.id.btn_ipc);
        Button button1=(Button) findViewById(R.id.btn_ipc_intent_service);
        Button button2=(Button) findViewById(R.id.btn_ipc_stop_intent_service);
        Button button3=(Button) findViewById(R.id.btn_ipc_messenger);
        UserManager.sUserId=2;
        LogUtil.e(TAG,UserManager.sUserId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.e("MainActivity","响应了");
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data","xiaoxi");
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.e(TAG, Thread.currentThread().getId());
                intent=new Intent(MainActivity.this, MyIntentService.class);
                intent.setAction(MyIntentService.ACTION_DOWN_IMG);
                startService(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent!=null){
                    stopService(intent);
                    intent=null;
                }
                LogUtil.e(TAG,"stopService");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,BookManagerService.class);
                bindService(intent,mConnection,BIND_AUTO_CREATE);
            }
        });

    }

    @Override
    protected void onDestroy() {
        LogUtil.e(TAG,"执行onDestroy");
        if (mRemoteBookManager!=null&&mRemoteBookManager.asBinder().isBinderAlive()){
            try {
                LogUtil.e(TAG,"unregister listener "+mOnNewBookArrivedListener);
                mRemoteBookManager.unregisterListener(mOnNewBookArrivedListener);
            }catch (RemoteException e){
                e.printStackTrace();
            }
        }
        unbindService(mConnection);
        super.onDestroy();

    }

    /**
     * 通过messenger进行通信的connection
     */
    /*
    private ServiceConnection mConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService=new Messenger(service);
            Message msg=Message.obtain(null,1);
            Bundle data=new Bundle();
            data.putString("msg","this is client");
            msg.setData(data);
            msg.replyTo=mGetReplyMessage;//这里收到服务端返回的数据
            try {
                mService.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };*/

    private ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            final IBookManager bookManager=IBookManager.Stub.asInterface(service);
            try{
                mRemoteBookManager=bookManager;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <5 ; i++) {
                            try {
                                List<Book> list=bookManager.getBookList();
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
//                LogUtil.e(TAG,"list的类型 "+list.getClass().getCanonicalName());
//                LogUtil.e(TAG,"query book list "+list.toString());
                LogUtil.e("onServiceConnected线程测试"+Thread.currentThread().getId());

                Book newBook=new Book(3,"java");
                bookManager.addBook(newBook);

                List<Book> newList=bookManager.getBookList();
                LogUtil.e(TAG,"list的类型 "+newList.getClass().getCanonicalName());
                LogUtil.e(TAG,"query book list "+newList.toString());
                bookManager.registerListener(mOnNewBookArrivedListener);
                bookManager.registerListener(mOnNewBookArrivedListener);
                service.linkToDeath(new IBinder.DeathRecipient() {
                    @Override
                    public void binderDied() {
                        LogUtil.e(TAG,"断开了链接");
                    }
                },0);
            }catch (RemoteException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    /**
     * messenger收到从服务器返回的数据
     */
    /*
    private Messenger mGetReplyMessage=new Messenger(new MessengerHandler());

    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    LogUtil.e(TAG,"receive msg from Client"+msg.getData().getString("msg"));
                    break;
                default:
                    super.handleMessage(msg);

            }
        }
    }*/

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    LogUtil.e(TAG,"receive new book : "+msg.obj);
                    LogUtil.e("线程测试"+Thread.currentThread().getId());
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    };

    private IOnNewBookArrivedListener mOnNewBookArrivedListener= new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            mHandler.obtainMessage(1,newBook).sendToTarget();
            LogUtil.e("线程测试"+Thread.currentThread().getId());
        }
    };


}
