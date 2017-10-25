package cn.huashantech.liaoliao2.entity.vo;

import java.util.List;

import cn.huashantech.liaoliao2.entity.Base.BaseEntity;
import cn.huashantech.liaoliao2.entity.po.AssetInfoPO;
import cn.huashantech.liaoliao2.entity.po.ImUserPO;
import cn.huashantech.liaoliao2.entity.po.Level;
import cn.huashantech.liaoliao2.entity.po.MultimediaResourcePO;
import cn.huashantech.liaoliao2.entity.po.PostPO;
import cn.huashantech.liaoliao2.entity.po.SysUserPO;
import cn.huashantech.liaoliao2.entity.po.UserRoleInfo;

/**
 * 用户主页展示
 *
 * @author lihang
 * @create 2017-06-16 下午5:46
 */
public class UserHomePageVO extends BaseEntity<UserHomePageVO> {
    private SysUserPO sysUserPO;
    private Level levelResponse;
    private MultimediaResourcePO voice;
    private Integer userRelation;
    private UserRoleInfo userRoleInfo;
    private UserCounterVO userCounterVO;
    private AssetInfoPO assetInfoPO;
    private ImUserPO imUserPO;
    private Integer black;
    private List<PostPO> postList;

    public Integer getBlack() {
        return black;
    }

    public void setBlack(Integer black) {
        this.black = black;
    }

    public List<PostPO> getPostList() {
        return postList;
    }

    public void setPostList(List<PostPO> postList) {
        this.postList = postList;
    }

    public ImUserPO getImUserPO() {
        return imUserPO;
    }

    public void setImUserPO(ImUserPO imUserPO) {
        this.imUserPO = imUserPO;
    }

    public MultimediaResourcePO getVoice() {
        return voice;
    }

    public void setVoice(MultimediaResourcePO voice) {
        this.voice = voice;
    }

    public SysUserPO getSysUserPO() {
        return sysUserPO;
    }

    public void setSysUserPO(SysUserPO sysUserPO) {
        this.sysUserPO = sysUserPO;
    }

    public Level getLevelResponse() {
        return levelResponse;
    }

    public void setLevelResponse(Level levelResponse) {
        this.levelResponse = levelResponse;
    }

    public Integer getUserRelation() {
        return userRelation;
    }

    public void setUserRelation(Integer userRelation) {
        this.userRelation = userRelation;
    }

    public UserRoleInfo getUserRoleInfo() {
        return userRoleInfo;
    }

    public void setUserRoleInfo(UserRoleInfo userRoleInfo) {
        this.userRoleInfo = userRoleInfo;
    }


    public UserCounterVO getUserCounterVO() {
        return userCounterVO;
    }

    public void setUserCounterVO(UserCounterVO userCounterVO) {
        this.userCounterVO = userCounterVO;
    }

    public AssetInfoPO getAssetInfoPO() {
        return assetInfoPO;
    }

    public void setAssetInfoPO(AssetInfoPO assetInfoPO) {
        this.assetInfoPO = assetInfoPO;
    }

    @Override
    public String toString() {
        return "UserHomePageVO{" +
                "sysUserPO=" + sysUserPO +
                ", levelResponse=" + levelResponse +
                ", voice=" + voice +
                ", userRelation=" + userRelation +
                ", userRoleInfo=" + userRoleInfo +
                ", userCounterVO=" + userCounterVO +
                ", assetInfoPO=" + assetInfoPO +
                ", imUserPO=" + imUserPO +
                ", black=" + black +
                ", postList=" + postList +
                '}';
    }
}
