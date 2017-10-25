package cn.huashantech.liaoliao2.entity.dto;


import cn.huashantech.liaoliao2.entity.po.UserDeviceInfo;

/**
 * 登陆所需参数
 *
 * @author lihang
 * @create 2017-06-10 下午5:22
 */
public class LoginRequestDTO {
    private String phoneNumber;
    private String verificationCode;
    private UserDeviceInfo userDeviceInfo;
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public UserDeviceInfo getUserDeviceInfo() {
        return userDeviceInfo;
    }

    public void setUserDeviceInfo(UserDeviceInfo userDeviceInfo) {
        this.userDeviceInfo = userDeviceInfo;
    }
}
