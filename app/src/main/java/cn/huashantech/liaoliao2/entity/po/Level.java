package cn.huashantech.liaoliao2.entity.po;


import cn.huashantech.liaoliao2.entity.Base.BaseEntity;

/**
 * 用户等级
 *
 * @author lihang
 * @create 2017-06-16 下午5:49
 */
public class Level extends BaseEntity<Level> {
    private int id;
    private String iconPath;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
