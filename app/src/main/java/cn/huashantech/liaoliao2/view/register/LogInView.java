package cn.huashantech.liaoliao2.view.register;

import cn.huashantech.liaoliao2.model.register.LoginDTO;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public interface LogInView {

    void getVerificationCode();

    void logIn(LoginDTO loginDTO);

    void showLoading();

    void hideLoading();
}
