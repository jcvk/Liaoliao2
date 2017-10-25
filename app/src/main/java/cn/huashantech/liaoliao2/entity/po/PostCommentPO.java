package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;

public class PostCommentPO {
    private Long id;

    private Long postId;

    private Long userId;

    private String content;

    private Integer deleteFlag;

    private Date gmtCreate;

    private Date gmtModified;

    private SysUserPO sysUserPO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public SysUserPO getSysUserPO() {
        return sysUserPO;
    }

    public void setSysUserPO(SysUserPO sysUserPO) {
        this.sysUserPO = sysUserPO;
    }
}