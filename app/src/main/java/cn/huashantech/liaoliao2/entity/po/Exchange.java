package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;

public class Exchange {
    private Long id;

    private Integer rmbValue;

    private Integer coinValue;

    private String productId;

    private Integer extraCoin;

    private Date gmtCreate;

    private Date gmtModified;

    public Exchange(Integer rmbValue, Integer coinValue, String productId, Integer extraCoin) {
        this.rmbValue = rmbValue;
        this.coinValue = coinValue;
        this.productId = productId;
        this.extraCoin = extraCoin;
    }

    public Integer getExtraCoin() {
        return extraCoin;
    }

    public void setExtraCoin(Integer extraCoin) {
        this.extraCoin = extraCoin;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRmbValue() {
        return rmbValue;
    }

    public void setRmbValue(Integer rmbValue) {
        this.rmbValue = rmbValue;
    }

    public Integer getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(Integer coinValue) {
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
}