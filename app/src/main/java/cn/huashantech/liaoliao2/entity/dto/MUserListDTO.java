package cn.huashantech.liaoliao2.entity.dto;

/**
 * 后台管理用户列表参数封装
 *
 * @author lihang
 * @create 2017-06-18 上午10:58
 */
public class MUserListDTO {
    private Integer idSort;
    private Integer gmtCreateSort;
    private Long id;
    private String nickName;
    private String phone;
    private Integer pageNum;
    private Integer pageSize;

    public Integer getIdSort() {
        return idSort;
    }

    public void setIdSort(Integer idSort) {
        this.idSort = idSort;
    }

    public Integer getGmtCreateSort() {
        return gmtCreateSort;
    }

    public void setGmtCreateSort(Integer gmtCreateSort) {
        this.gmtCreateSort = gmtCreateSort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
