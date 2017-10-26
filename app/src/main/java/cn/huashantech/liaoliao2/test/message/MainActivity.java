package cn.huashantech.liaoliao2.test.message;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.SmsMessage;
import android.widget.TextView;

import cn.huashantech.liaoliao2.R;

/**
 * Created by Dingkang Qin on 2017/10/25.
 * emails: qindingkang@huashantech.cn
 */

public class MainActivity extends Activity {

    private TextView sender;
    private TextView contentText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_test);
        initView();
    }

    private void initView(){
        sender=(TextView)findViewById(R.id.sender_message_test);
        contentText=(TextView)findViewById(R.id.content_message_test);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle=intent.getExtras();
            Object[] pdus=(Object[])bundle.get("pdus");
            SmsMessage[] messages=new SmsMessage[pdus.length];
            for(int i=0;i<messages.length;i++){
                messages[i]= SmsMessage.createFromPdu((byte[])pdus[i]);
            }

            String address=messages[0].getOriginatingAddress();

            String fullMessage="";
            for (SmsMessage message:messages){
                fullMessage+=message.getMessageBody();
            }
            sender.setText(address);
            contentText.setText(fullMessage);

        }

    }
}
