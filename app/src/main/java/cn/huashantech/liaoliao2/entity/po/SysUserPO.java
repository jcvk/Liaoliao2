package cn.huashantech.liaoliao2.entity.po;

import java.util.Arrays;
import java.util.Date;

import cn.huashantech.liaoliao2.entity.Base.BaseEntity;

public class SysUserPO extends BaseEntity<SysUserPO> implements Cloneable {
    private Long id;
    private String username;
    private String password;
    private String nickName;
    private String avatarUrl;
    //性别  0男生 1女生
    private int gender;
    private Date birthday;
    private String city;
    private String province;
    private String country;
    private String backgroundPic;
    private Long voiceResourceId;
    private Date lastActiveTime;
    //个人标签
    private String[] personLabel;
    //行业
    private String[] industryLabel;
    private String personSignature;
    private String longitude;
    private String latitude;
    private String email;
    private int userStatus;
    private String salt;
    private String inviteCode;
    private String inviter;
    private Date gmtCreate;
    private Date gmtModified;
    private int height;
    private int weight;
    //视频认证
    private long videoResourceId;

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public Long getVoiceResourceId() {
        return voiceResourceId;
    }

    public void setVoiceResourceId(Long voiceResourceId) {
        this.voiceResourceId = voiceResourceId;
    }

    public String getBackgroundPic() {
        return backgroundPic;
    }

    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic;
    }

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getPersonSignature() {
        return personSignature;
    }

    public void setPersonSignature(String personSignature) {
        this.personSignature = personSignature == null ? null : personSignature.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
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

    public String[] getPersonLabel() {
        return personLabel;
    }

    public void setPersonLabel(String[] personLabel) {
        this.personLabel = personLabel;
    }

    public String[] getIndustryLabel() {
        return industryLabel;
    }

    public void setIndustryLabel(String[] industryLabel) {
        this.industryLabel = industryLabel;
    }

    @Override
    public String toString() {
        return "SysUserPO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", backgroundPic='" + backgroundPic + '\'' +
                ", voiceResourceId=" + voiceResourceId +
                ", lastActiveTime=" + lastActiveTime +
                ", personLabel=" + Arrays.toString(personLabel) +
                ", industryLabel=" + Arrays.toString(industryLabel) +
                ", personSignature='" + personSignature + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", email='" + email + '\'' +
                ", userStatus=" + userStatus +
                ", salt='" + salt + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", inviter='" + inviter + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public long getVideoResourceId() {
        return videoResourceId;
    }

    public void setVideoResourceId(long videoResourceId) {
        this.videoResourceId = videoResourceId;
    }
}