package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;
import java.util.Map;

public class CoinRecordPO {
    private Long id;

    private Long userId;

    private Long changeAmount;

    private String changeDescription;

    private Long balance;

    private Integer type;

    private Map extMap;

    private Date gmtCreate;

    private Date gmtModified;

    public CoinRecordPO(Long userId, Long changeAmount, String changeDescription, Long balance, Integer type, Map extMap) {
        this.userId = userId;
        this.changeAmount = changeAmount;
        this.changeDescription = changeDescription;
        this.balance = balance;
        this.type = type;
        this.extMap = extMap;
    }

    public CoinRecordPO() {
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

    public Long getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(Long changeAmount) {
        this.changeAmount = changeAmount;
    }

    public String getChangeDescription() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription = changeDescription == null ? null : changeDescription.trim();
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Map getExtMap() {
        return extMap;
    }

    public void setExtMap(Map extMap) {
        this.extMap = extMap;
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
        return "CoinRecordPO{" +
                "id=" + id +
                ", userId=" + userId +
                ", changeAmount=" + changeAmount +
                ", changeDescription='" + changeDescription + '\'' +
                ", balance=" + balance +
                ", type=" + type +
                ", extMap=" + extMap +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}