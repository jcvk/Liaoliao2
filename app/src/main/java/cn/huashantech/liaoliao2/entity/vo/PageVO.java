package cn.huashantech.liaoliao2.entity.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * 分页参数VO
 *
 * @author lihang
 * @create 2017-06-16 上午9:39
 */
public class PageVO {
    private Integer pageNum;
    private Integer pageSize;
    private ArrayList<Long> ids;
    private Date date;

    public PageVO(int pageNum, int pageSize, Date date) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.date = date;
    }

    public PageVO(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
    public PageVO() {

    }

    public ArrayList<Long> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Long> ids) {
        this.ids = ids;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
