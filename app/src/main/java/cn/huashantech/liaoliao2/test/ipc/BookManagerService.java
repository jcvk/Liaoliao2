package cn.huashantech.liaoliao2.test.ipc;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import cn.huashantech.liaoliao2.aidl.Book;
import cn.huashantech.liaoliao2.aidl.IBookManager;
import cn.huashantech.liaoliao2.aidl.IOnNewBookArrivedListener;
import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2018/3/16.
 * emails: qindingkang@huashantech.cn
 */

public class BookManagerService extends Service {

    public static final String TAG = "BookManagerService";

    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();
    //用这种方法会导致无法解除注册
//    private CopyOnWriteArrayList<IOnNewBookArrivedListener> mListenerList =
//            new CopyOnWriteArrayList<>();
    private RemoteCallbackList<IOnNewBookArrivedListener> mListenerList = new RemoteCallbackList<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        int check=checkCallingOrSelfPermission("cn.huashantech.liaoliao2.permission.ACCESS_BOOK_SERVICE");
        if (check== PackageManager.PERMISSION_DENIED){
            return null;
        }
        return mBinder;
    }

    private Binder mBinder = new IBookManager.Stub() {

        @Override
        public List<Book> getBookList() throws RemoteException {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
            //直接用CopyOnWriteArrayList出现的弊端，同一个listener也会添加两次
//            if (!mListenerList.contains(listener)){
//                mListenerList.add(listener);
//            }else {
//                LogUtil.e(TAG,"已经添加过了");
//            }
//            LogUtil.e(TAG,"register后 mListener的长度 "+mListenerList.size());
            mListenerList.register(listener);
            LogUtil.e(TAG, "register后 mListener的长度 " +mListenerList.getRegisteredCallbackCount());

        }


        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
//            if (mListenerList.contains(listener)){
//                mListenerList.remove(listener);
//                LogUtil.e(TAG,"unregister successful");
//            }else {
//                LogUtil.e(TAG,"not found,can not found unregister");
//            }
//            LogUtil.e(TAG,"unregister后  mListener的长度 "+mListenerList.size());
            mListenerList.unregister(listener);
        }
    };

    private void onNewBookArrived(Book book) throws RemoteException {
        mBookList.add(book);
//        LogUtil.e(TAG,"onNewBookArrived, notify listeners: " + mListenerList.size());
//        for (int i=0;i<mListenerList.size();i++){
//            IOnNewBookArrivedListener listener=mListenerList.get(i);
//            LogUtil.e(TAG,"onNewBookArrived, notify listener: "+ listener);
//            listener.onNewBookArrived(book);
//        }

        final int N = mListenerList.beginBroadcast();
        for (int i = 0; i < N; i++) {
            IOnNewBookArrivedListener l = mListenerList.getBroadcastItem(i);
            if (l != null) {
                l.onNewBookArrived(book);
            }

        }
        mListenerList.finishBroadcast();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1, "android"));
        mBookList.add(new Book(2, "ios"));
        new Thread(new ServiceWorker()).start();

    }

    private class ServiceWorker implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (i < 20) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int bookId = mBookList.size() + 1;
                Book newBook = new Book(bookId, "new book#" + bookId);
                try {
                    onNewBookArrived(newBook);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
}
