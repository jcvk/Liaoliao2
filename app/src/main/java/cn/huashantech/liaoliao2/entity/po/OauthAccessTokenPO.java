package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;

public class OauthAccessTokenPO {
    private Long id;

    private Long userId;

    private String userName;

    private String accessTokenValue;

    private String refreshTokenValue;

    private Date expiration;

    private String userAuthorities;

    private String clientId;

    private String clientAuthorities;

    private String clientScope;

    private String authenticationId;

    private Long companyId;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAccessTokenValue() {
        return accessTokenValue;
    }

    public void setAccessTokenValue(String accessTokenValue) {
        this.accessTokenValue = accessTokenValue == null ? null : accessTokenValue.trim();
    }

    public String getRefreshTokenValue() {
        return refreshTokenValue;
    }

    public void setRefreshTokenValue(String refreshTokenValue) {
        this.refreshTokenValue = refreshTokenValue == null ? null : refreshTokenValue.trim();
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(String userAuthorities) {
        this.userAuthorities = userAuthorities == null ? null : userAuthorities.trim();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getClientAuthorities() {
        return clientAuthorities;
    }

    public void setClientAuthorities(String clientAuthorities) {
        this.clientAuthorities = clientAuthorities == null ? null : clientAuthorities.trim();
    }

    public String getClientScope() {
        return clientScope;
    }

    public void setClientScope(String clientScope) {
        this.clientScope = clientScope == null ? null : clientScope.trim();
    }

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId == null ? null : authenticationId.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}