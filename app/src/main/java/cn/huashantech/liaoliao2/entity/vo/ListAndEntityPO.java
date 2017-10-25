package cn.huashantech.liaoliao2.entity.vo;

import java.util.List;

/**
 * @author lihang
 * @create 2017-07-11 上午10:43
 */
public class ListAndEntityPO<T,V> {
    private List<T> list;
    private V entity;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public V getEntity() {
        return entity;
    }

    public void setEntity(V entity) {
        this.entity = entity;
    }
}
