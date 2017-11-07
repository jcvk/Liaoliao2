package cn.huashantech.liaoliao2.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.huashantech.liaoliao2.R;

/**
 * Created by Dingkang Qin on 2017/9/17.
 * emails: qindingkang@huashantech.cn
 */

public abstract class BaseActivity extends AppCompatActivity {

    //进度条
    protected ProgressDialog progressDialog;

    //头部布局
    private ImageView mBackImage;
    private TextView mTitle;
    private TextView mSubTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layId = getContentLayoutId();
        mBackImage =(ImageView)findViewById(R.id.img_tool_bar_back);
        mTitle=(TextView)findViewById(R.id.tv_tool_bar_title);
        mSubTitle=(TextView)findViewById(R.id.tv_tool_bar_subtitle);
        setContentView(layId);
        ButterKnife.bind(this);
        initData();
        initWidget();
    }

    /**
     * 显示progressDialog
     *
     * @param resId
     */
    protected void showProgressDialog(@StringRes int resId) {
        //getString()方法是context的
        String message = getString(resId);
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    /**
     * 关闭progressDialog
     */
    protected void disMissProgressDialog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
        super.onDestroy();
    }

    /**
     * 设置标题文字
     * @param resId
     */
    protected void setTitleText(@StringRes int resId){
        String titleMessage=getString(resId);
        mTitle.setText(titleMessage);
    }

    /**
     * 设置副标题是否可见
     * @param isShow
     */
    protected void setSubTitleShow(boolean isShow){
        if (isShow){
            mSubTitle.setVisibility(View.VISIBLE);
        }else {
            mSubTitle.setVisibility(View.GONE);
        }
    }

    /**
     * 设置副标题文字
     * @param resId
     */
    protected void setSubTitleText(@StringRes int resId){
        String subTitleMessage=getString(resId);
        mSubTitle.setText(subTitleMessage);
    }

    /**
     * 返回键点击事件
     */
    @OnClick(R.id.img_tool_bar_back)
    void onClicked(){
        finish();
    }

    /**
     * 设置返回键是否可见
     * @param isShow
     */
    protected void setBackImageShow(boolean isShow){
        if (isShow){
            mBackImage.setVisibility(View.VISIBLE);
        }else {
            mBackImage.setVisibility(View.GONE);
        }
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件
     */
    protected abstract void initWidget();

    /**
     * 获取当前界面资源id
     *
     * @return
     */
    protected abstract int getContentLayoutId();

}
