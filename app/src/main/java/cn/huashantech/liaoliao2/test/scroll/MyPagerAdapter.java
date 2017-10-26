package cn.huashantech.liaoliao2.test.scroll;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Dingkang Qin on 2017/10/26.
 * emails: qindingkang@huashantech.cn
 */

public class MyPagerAdapter extends PagerAdapter{

    private ArrayList<View> arrayList;

    public MyPagerAdapter(ArrayList<View> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(arrayList.get(position));
        return arrayList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(arrayList.get(position));
    }
}
