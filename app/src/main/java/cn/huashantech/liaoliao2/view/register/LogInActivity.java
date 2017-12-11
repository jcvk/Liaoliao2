package cn.huashantech.liaoliao2.view.register;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.huashantech.liaoliao2.LiaoLiaoApplication;
import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.base.ActivityPresenter;
import cn.huashantech.liaoliao2.base.BaseContract;
import cn.huashantech.liaoliao2.config.CacheConfig;
import cn.huashantech.liaoliao2.entity.dto.LoginRequestDTO;
import cn.huashantech.liaoliao2.entity.po.SysUserPO;
import cn.huashantech.liaoliao2.entity.vo.UserHomePageVO;
import cn.huashantech.liaoliao2.model.register.LoginDTO;
import cn.huashantech.liaoliao2.presenter.register.LogInPresenterImpl;
import cn.huashantech.liaoliao2.utils.CacheUtil;
import cn.huashantech.liaoliao2.utils.LogUtil;
import cn.huashantech.liaoliao2.utils.ToastUtil;
import cn.huashantech.liaoliao2.view.information.InformationActivity;
import cn.huashantech.liaoliao2.view.main.HomeActivity;
import cn.huashantech.liaoliao2.widget.CountDownButton;

/**
 * Created by Dingkang Qin on 2017/9/17.
 * emails: qindingkang@huashantech.cn
 */

public class LogInActivity extends ActivityPresenter implements LogInView{

    @BindView(R.id.edit_phone)
    EditText phoneEditText;
    @BindView(R.id.edit_identity)
    EditText identityEditText;
    @BindView(R.id.btn_login)
    Button loginButton;
    @BindView(R.id.user_agreement)
    TextView agreementTv;
    @BindView(R.id.btn_identity)
    CountDownButton countDownButton;

    private LogInPresenterImpl logInPresenter;
    private CacheUtil cacheUtil;

    @Override
    protected BaseContract.Presenter initPresenter() {
        logInPresenter=new LogInPresenterImpl(this);
        return null;
    }

    @Override
    protected void initData() {
        cacheUtil= LiaoLiaoApplication.getInstance().getCacheUtil();

    }

    @Override
    protected void initWidget() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_identity)
    void onIdentityBtnClick(){
        String phoneNumber=phoneEditText.getText().toString();
        logInPresenter.getVerificationCode(phoneNumber);
    }

    @OnClick(R.id.btn_login)
    void onLoginBtnClick(){
        String identity=identityEditText.getText().toString();
        String phoneNumber=phoneEditText.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)){
            ToastUtil.showToast(R.string.write_phone_number);
        }else if (phoneNumber.length()!=11){
            ToastUtil.showToast(R.string.write_right_number);
        }else {
            LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
            loginRequestDTO.setPhoneNumber(phoneNumber);
            loginRequestDTO.setVerificationCode(identity);
            logInPresenter.getLogInDTO(loginRequestDTO);
        }
    }

    @Override
    public void getVerificationCode() {

    }

    @Override
    public void logIn(LoginDTO loginDTO) {
        cacheDate(loginDTO);



    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private void cacheDate(LoginDTO loginDTO){
        String accessToken=loginDTO.getAccessToken();
        String refreshToken=loginDTO.getRefreshToken();
        UserHomePageVO userHomePageVO=loginDTO.getHomePageVO();
        cacheUtil.putSerializableObj(CacheConfig.USER_KEY,userHomePageVO);
        cacheUtil.putString(CacheConfig.ACCESS_TOKEN,accessToken);
        cacheUtil.putString(CacheConfig.REFRESH_TOKEN,refreshToken);
        intoActivity(userHomePageVO);
    }

    private void intoActivity(UserHomePageVO userHomePageVO){
        SysUserPO sysUserPO=userHomePageVO.getSysUserPO();
        switch (sysUserPO.getUserStatus()){
            case 0:
                Intent intent=new Intent(LogInActivity.this, InformationActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1=new Intent(LogInActivity.this, HomeActivity.class);
                startActivity(intent1);
                break;
            default:
                LogUtil.e("error status");
                break;

        }
    }
}
