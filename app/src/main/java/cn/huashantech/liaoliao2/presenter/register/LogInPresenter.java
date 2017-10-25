package cn.huashantech.liaoliao2.presenter.register;

import cn.huashantech.liaoliao2.entity.dto.LoginRequestDTO;
import cn.huashantech.liaoliao2.model.register.LoginDTO;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public interface LogInPresenter {

    void getLogInDTO(LoginRequestDTO loginRequestDTO);

    void getVerificationCode(String phoneNumber);

    void getLogInDTOSuccess(LoginDTO loginDTO);

    void getVerificationCodeSuccess();
}
