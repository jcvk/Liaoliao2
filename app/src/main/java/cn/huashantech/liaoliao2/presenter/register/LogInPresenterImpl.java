package cn.huashantech.liaoliao2.presenter.register;

import cn.huashantech.liaoliao2.base.BaseContract;
import cn.huashantech.liaoliao2.base.BasePresenter;
import cn.huashantech.liaoliao2.entity.dto.LoginRequestDTO;
import cn.huashantech.liaoliao2.model.register.LoginDTO;
import cn.huashantech.liaoliao2.model.register.ModelHelper;
import cn.huashantech.liaoliao2.view.register.LogInView;

/**
 * Created by Dingkang Qin on 2017/9/17.
 * emails: qindingkang@huashantech.cn
 */

public class LogInPresenterImpl extends BasePresenter implements LogInPresenter{

    private LogInView logInView;

    /**
     * p层构造方法
     * 创建p层时就进行双向绑定
     *
     * @param mView v层的引用
     */
    public LogInPresenterImpl(BaseContract.View mView) {
        super(mView);
        this.logInView=(LogInView) mView;
    }

    @Override
    public void getLogInDTO(LoginRequestDTO loginRequestDTO) {
        logInView.showLoading();
        //调用ModelHelper
        ModelHelper.requestLogInDTO(loginRequestDTO,this);
    }

    @Override
    public void getVerificationCode(String phoneNumber) {
        ModelHelper.requestVerificationCode(phoneNumber,this);

    }

    @Override
    public void getLogInDTOSuccess(LoginDTO loginDTO) {
        logInView.hideLoading();
        logInView.logIn(loginDTO);

    }


    @Override
    public void getVerificationCodeSuccess() {
        logInView.getVerificationCode();

    }
}
