package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;

public class RechargeRecordPO {
    private Long id;

    private Long userId;

    private Long exchangeId;

    private Integer rechargeType;

    private Long rechargeRmb;

    private Long rechargeCoin;

    private Date gmtCreate;

    private Date gmtModified;

    private String productId;

    private String orderToken;

    private String alipayOrderString;


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

    public Long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    public Integer getRechargeType() {
        return rechargeType;
    }

    public void setRechargeType(Integer rechargeType) {
        this.rechargeType = rechargeType;
    }

    public Long getRechargeRmb() {
        return rechargeRmb;
    }

    public void setRechargeRmb(Long rechargeRmb) {
        this.rechargeRmb = rechargeRmb;
    }

    public Long getRechargeCoin() {
        return rechargeCoin;
    }

    public void setRechargeCoin(Long rechargeCoin) {
        this.rechargeCoin = rechargeCoin;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderToken() {
        return orderToken;
    }

    public void setOrderToken(String orderToken) {
        this.orderToken = orderToken;
    }

    public String getAlipayOrderString() {
        return alipayOrderString;
    }

    public void setAlipayOrderString(String alipayOrderString) {
        this.alipayOrderString = alipayOrderString;
    }
}