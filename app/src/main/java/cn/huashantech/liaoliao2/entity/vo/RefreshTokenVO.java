package cn.huashantech.liaoliao2.entity.vo;


/**
 * 刷新token参数封装对象
 *
 * @author lihang
 * @create 2017-06-11 下午7:10
 */
public class RefreshTokenVO {
    private long userId;
    private String refreshToken;
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
