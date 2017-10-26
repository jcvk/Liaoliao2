package cn.huashantech.liaoliao2.test.scroll;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2017/10/26.
 * emails: qindingkang@huashantech.cn
 */

public class TestActivity extends Activity {

    private ListView listView1;
    private ListView listView2;
    private ViewPager viewPager;
    private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_test);
        initView();
        initViewPager();
    }

    private void initView(){
        listView1=(ListView)findViewById(R.id.scroll_test_list);
        viewPager=(ViewPager)findViewById(R.id.scroll_test_viewpager);
        listView2=(ListView)findViewById(R.id.scroll_test_list_2);
        ArrayList<String> data=new ArrayList<>();
        for (int i=0;i<50;i++){
            data.add(i+"hello");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.content_list_item,R.id.contain_list_item,data);
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView1);
        setListViewHeightBasedOnChildren(listView2);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TestActivity.this,"click item"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setListViewHeightBasedOnChildren(ListView listView){
        ListAdapter listAdapter=listView.getAdapter();
        if (listAdapter!=null){
            int totalHeight=0;
            LogUtil.e("scroll","怎么说");
            for (int i=0,len=listAdapter.getCount();i<len;i++){
                View listItem=listAdapter.getView(i,null,listView);
                listItem.measure(0,0);
                totalHeight+=listItem.getMeasuredHeight();
            }

            ViewGroup.LayoutParams params=listView.getLayoutParams();
            params.height=totalHeight+(listView.getDividerHeight()*(listAdapter.getCount()-1));
            LogUtil.e("scroll",params.height);
            listView.setLayoutParams(params);
            listView.invalidate();
        }
    }

    public void initViewPager(){

        LayoutInflater layoutInflater=getLayoutInflater();
        ArrayList<View> arrayList=new ArrayList<>();
        View view=layoutInflater.inflate(R.layout.item_test_viewpager,null,false);
        view.setBackgroundColor(getResources().getColor(R.color.colorBackWhite));
        arrayList.add(view);
        View view1=layoutInflater.inflate(R.layout.item_test_viewpager,null,false);
        view1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        arrayList.add(view1);
        View view2=layoutInflater.inflate(R.layout.item_test_viewpager,null,false);
        view2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        arrayList.add(view2);
        pagerAdapter=new MyPagerAdapter(arrayList);
        viewPager.setAdapter(pagerAdapter);

    }
}
