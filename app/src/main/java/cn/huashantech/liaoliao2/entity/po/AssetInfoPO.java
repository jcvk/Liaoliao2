package cn.huashantech.liaoliao2.entity.po;


import java.util.Date;

public class AssetInfoPO {
    private Long id;

    private Long userId;
    private Long pointValue;
    private Long coinValue;
    private Long rewardCoinValue;
    private Long realCoinValue;

    private Integer voiceCallPrice;

    private Integer videoCallPrice;

    private Date gmtCreate;

    private Date gmtModified;

    private double earnPropor;

    public Integer getVoiceCallPrice() {
        return voiceCallPrice;
    }

    public void setVoiceCallPrice(Integer voiceCallPrice) {
        this.voiceCallPrice = voiceCallPrice;
    }

    public Integer getVideoCallPrice() {
        return videoCallPrice;
    }

    public void setVideoCallPrice(Integer videoCallPrice) {
        this.videoCallPrice = videoCallPrice;
    }

    public Long getRealCoinValue() {
        return realCoinValue;
    }

    public void setRealCoinValue(Long realCoinValue) {
        this.realCoinValue = realCoinValue;
    }

    public Long getRewardCoinValue() {
        return rewardCoinValue;
    }

    public void setRewardCoinValue(Long rewardCoinValue) {
        this.rewardCoinValue = rewardCoinValue;
    }

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

    public Long getPointValue() {
        return pointValue;
    }

    public void setPointValue(Long pointValue) {
        this.pointValue = pointValue;
    }

    public Long getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(Long coinValue) {
        this.coinValue = coinValue;
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

    @Override
    public String toString() {
        return "AssetInfoPO{" +
                "id=" + id +
                ", userId=" + userId +
                ", pointValue=" + pointValue +
                ", coinValue=" + coinValue +
                ", rewardCoinValue=" + rewardCoinValue +
                ", realCoinValue=" + realCoinValue +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public double getEarnPropor() {
        return earnPropor;
    }

    public void setEarnPropor(double earnPropor) {
        this.earnPropor = earnPropor;
    }
}