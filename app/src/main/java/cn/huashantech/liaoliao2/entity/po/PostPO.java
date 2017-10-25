package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;
import java.util.List;

import cn.huashantech.liaoliao2.entity.Base.BaseEntity;
import cn.huashantech.liaoliao2.entity.vo.UserHomePageVO;


public class PostPO extends BaseEntity<PostPO> implements Comparable<PostPO> {
    private Long id;

    private UserHomePageVO userHomePageVO;

    private Long userId;

    private String longitude;

    private String latitude;

    private String distance;

    private Double distanceValue;

    private int like;

    private int giveGift;

    private Integer likeCount;

    private Integer commentCount;

    private Integer giftCount;

    private List<PostContentPO> postContentPOList;

    private List<PostCommentPO> postCommentPOList;

    private Date gmtCreate;

    private Date gmtModified;

    private String nickName;

    private String avatarUrl;

    private  int type;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public int getGiveGift() {
        return giveGift;
    }

    public void setGiveGift(int giveGift) {
        this.giveGift = giveGift;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public UserHomePageVO getUserHomePageVO() {
        return userHomePageVO;
    }

    public void setUserHomePageVO(UserHomePageVO userHomePageVO) {
        this.userHomePageVO = userHomePageVO;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
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

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(Integer giftCount) {
        this.giftCount = giftCount;
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

    public List<PostContentPO> getPostContentPOList() {
        return postContentPOList;
    }

    public void setPostContentPOList(List<PostContentPO> postContentPOList) {
        this.postContentPOList = postContentPOList;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Double getDistanceValue() {
        return distanceValue;
    }

    public void setDistanceValue(Double distanceValue) {
        this.distanceValue = distanceValue;
    }

    @Override
    public int compareTo(PostPO o) {
        return this.getDistanceValue().compareTo(o.getDistanceValue());
    }

    @Override
    public String toString() {
        return "PostPO{" +
                "id=" + id +
                ", userHomePageVO=" + userHomePageVO +
                ", userId=" + userId +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", distance='" + distance + '\'' +
                ", distanceValue=" + distanceValue +
                ", like=" + like +
                ", likeCount=" + likeCount +
                ", commentCount=" + commentCount +
                ", giftCount=" + giftCount +
                ", postContentPOList=" + postContentPOList +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }

    public List<PostCommentPO> getPostCommentPOList() {
        return postCommentPOList;
    }

    public void setPostCommentPOList(List<PostCommentPO> postCommentPOList) {
        this.postCommentPOList = postCommentPOList;
    }
}
