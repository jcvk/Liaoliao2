package cn.huashantech.liaoliao2.test.drawer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.huashantech.liaoliao2.R;

/**
 * Created by Dingkang Qin on 2017/10/31.
 * emails: qindingkang@huashantech.cn
 */

public class TestActivity extends Activity{

    private DrawerLayout drawerLayout;
    private ListView listView;
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drawer);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.RED);
        listView=(ListView)findViewById(R.id.left_drawer);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.add_widget,R.string.app_name);
        drawerLayout.setDrawerListener(toggle);
        list=new ArrayList<>();
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");

        listView.setAdapter(new ArrayAdapter<>(this,R.layout.item_music_cursor,R.id.text_music_name,list));



    }

}
