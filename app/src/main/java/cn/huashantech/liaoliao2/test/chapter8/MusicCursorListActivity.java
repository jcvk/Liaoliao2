package cn.huashantech.liaoliao2.test.chapter8;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import cn.huashantech.liaoliao2.R;

/**
 * Created by Dingkang Qin on 2017/10/30.
 * emails: qindingkang@huashantech.cn
 */

public class MusicCursorListActivity extends Activity {

    private ListView listView;
    private FileCursorAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_music_cursor);
        initView();


    }

    private void initView(){
        listView=(ListView)findViewById(R.id.list_music_cursor);
        Cursor cursor=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,MediaStore.Audio.Media.TITLE_KEY);
        adapter=new FileCursorAdapter(this,cursor);
        listView.setAdapter(adapter);
        cursor.close();
    }

    public class FileCursorAdapter extends CursorAdapter {
        private LayoutInflater layoutInflater;

        public FileCursorAdapter(Context context, Cursor c) {
            super(context, c, FLAG_AUTO_REQUERY);
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public void bindView(View view, Context arg1, Cursor cursor) {
            TextView titleTxt = (TextView) view.findViewById(R.id.text_music_name);

            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            titleTxt.setText(title);
        }

        @Override
        public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
            return layoutInflater.inflate(R.layout.item_music_cursor,null);
        }

    }
}
