package cn.huashantech.liaoliao2.entity.vo;

import java.util.Date;

import cn.huashantech.liaoliao2.entity.po.PostPO;


/**
 * 帖子点赞列表
 *
 * @author lihang
 * @create 2017-07-11 上午11:28
 */
public class PostLikeListVO {
    private UserHomePageVO likeUserHomePageInfo;
    private PostPO postPO;
    private Date gmtCreate;
    private int type;
    private String postCommentContent;


    public UserHomePageVO getLikeUserHomePageInfo() {
        return likeUserHomePageInfo;
    }

    public void setLikeUserHomePageInfo(UserHomePageVO likeUserHomePageInfo) {
        this.likeUserHomePageInfo = likeUserHomePageInfo;
    }

    public PostPO getPostPO() {
        return postPO;
    }

    public void setPostPO(PostPO postPO) {
        this.postPO = postPO;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "PostLikeListVO{" +
                "likeUserHomePageInfo=" + likeUserHomePageInfo +
                ", postPO=" + postPO +
                ", gmtCreate=" + gmtCreate +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPostCommentContent() {
        return postCommentContent;
    }

    public void setPostCommentContent(String postCommentContent) {
        this.postCommentContent = postCommentContent;
    }
}


