package cn.huashantech.liaoliao2.test.drawer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drawer);
        SystemClock.sleep(10*1000);




    }

}
