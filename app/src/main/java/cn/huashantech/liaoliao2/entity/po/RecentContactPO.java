package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;
import java.util.Map;

import cn.huashantech.liaoliao2.entity.Base.BaseEntity;


public class RecentContactPO  extends BaseEntity<RecentContactPO> {

    private Long fromUserId;

    private Long toUserId;

    private String fromUserNick;

    private String fromUserIcon;

    private String toUserNick;

    private String toUserIcon;

    private String content;

    private Integer unreadCount;

    private Map params;

    private Date gmtCreate;

    private Date gmtModified;

    public RecentContactPO() {
    }

    public RecentContactPO(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public String getFromUserNick() {
        return fromUserNick;
    }

    public void setFromUserNick(String fromUserNick) {
        this.fromUserNick = fromUserNick;
    }

    public String getFromUserIcon() {
        return fromUserIcon;
    }

    public void setFromUserIcon(String fromUserIcon) {
        this.fromUserIcon = fromUserIcon;
    }

    public String getToUserNick() {
        return toUserNick;
    }

    public void setToUserNick(String toUserNick) {
        this.toUserNick = toUserNick;
    }

    public String getToUserIcon() {
        return toUserIcon;
    }

    public void setToUserIcon(String toUserIcon) {
        this.toUserIcon = toUserIcon;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
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
        return "RecentContactPO{" +
                "fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", fromUserNick='" + fromUserNick + '\'' +
                ", fromUserIcon='" + fromUserIcon + '\'' +
                ", toUserNick='" + toUserNick + '\'' +
                ", toUserIcon='" + toUserIcon + '\'' +
                ", content='" + content + '\'' +
                ", unreadCount=" + unreadCount +
                ", params=" + params +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}