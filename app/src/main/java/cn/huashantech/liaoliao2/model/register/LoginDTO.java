package cn.huashantech.liaoliao2.model.register;

import cn.huashantech.liaoliao2.entity.Base.BaseEntity;
import cn.huashantech.liaoliao2.entity.vo.UserHomePageVO;

/**
 * 登陆成功后信息dto
 *
 * @author lihang
 * @create 2017-06-08 下午4:25
 */
public class LoginDTO extends BaseEntity<LoginDTO> {

    private String accessToken;
    private String refreshToken;
    private UserHomePageVO homePageVO;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    public UserHomePageVO getHomePageVO() {
        return homePageVO;
    }

    public void setHomePageVO(UserHomePageVO homePageVO) {
        this.homePageVO = homePageVO;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", homePageVO=" + homePageVO +
                '}';
    }
}
