package cn.huashantech.liaoliao2.entity.vo;

/**
 * @author lihang
 * @create 2017-06-27 下午4:11
 */
public class UserCounterVO {
    private Integer totalUnReadCount;
    private int beReportedCount;
    private int eventCount;
    private int followerCount;
    private int followingCount;
    private int temperature;
    private int totalRewardCount;
    private int totalFeedbackCount;
    private int visitorCount;

    public int getGroupCallCount() {
        return groupCallCount;
    }

    public void setGroupCallCount(int groupCallCount) {
        this.groupCallCount = groupCallCount;
    }

    private int groupCallCount;
    public int getBeReportedCount() {
        return beReportedCount;
    }

    public void setBeReportedCount(int beReportedCount) {
        this.beReportedCount = beReportedCount;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTotalRewardCount() {
        return totalRewardCount;
    }

    public void setTotalRewardCount(int totalRewardCount) {
        this.totalRewardCount = totalRewardCount;
    }

    public int getTotalFeedbackCount() {
        return totalFeedbackCount;
    }

    public void setTotalFeedbackCount(int totalFeedbackCount) {
        this.totalFeedbackCount = totalFeedbackCount;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    public Integer getTotalUnReadCount() {
        return totalUnReadCount;
    }

    public void setTotalUnReadCount(Integer totalUnReadCount) {
        this.totalUnReadCount = totalUnReadCount;
    }
}
