package wrx.xing;

import java.util.List;

/**
 * 请填写类的描述
 * 修改科室时传递给mq的消息类
 * @author wangruxing
 * @date 2018-04-24 11:38
 */
public class DepartmentMq {
    /**
     * 科室id
     */
    private Long Id;
    /**
     * 科室名称
     */
    private String departName;
    /**
     * 直接父科室id
     */
    private Long directParentId;
    /**
     * 直接父科室名称
     */
    private String directParentName;
    /**
     * 科室级别
     */
    private Integer departLevel;
    /**
     * 是否有子科室
     */
    private Boolean haveChildDepart;
    /**
     * 医生id
     */
    private List<Long> docIds;
    /**
     * 事件类型
     * 1：增加 2：删除 3：修改
     */
    private Integer type;

    /**
     * 父级的父级科室id
     */
    private Long grandpaDepartId;

    /**
     * 父级的父级科室名称
     */
    private String grandpaDepartName;

    public Long getGrandpaDepartId() {
        return grandpaDepartId;
    }

    public void setGrandpaDepartId(Long grandpaDepartId) {
        this.grandpaDepartId = grandpaDepartId;
    }

    public String getGrandpaDepartName() {
        return grandpaDepartName;
    }

    public void setGrandpaDepartName(String grandpaDepartName) {
        this.grandpaDepartName = grandpaDepartName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Long getDirectParentId() {
        return directParentId;
    }

    public void setDirectParentId(Long directParentId) {
        this.directParentId = directParentId;
    }

    public Integer getDepartLevel() {
        return departLevel;
    }

    public void setDepartLevel(Integer departLevel) {
        this.departLevel = departLevel;
    }

    public Boolean getHaveChildDepart() {
        return haveChildDepart;
    }

    public void setHaveChildDepart(Boolean haveChildDepart) {
        this.haveChildDepart = haveChildDepart;
    }

    public List<Long> getDocIds() {
        return docIds;
    }

    public void setDocIds(List<Long> docIds) {
        this.docIds = docIds;
    }

    public String getDirectParentName() {
        return directParentName;
    }

    public void setDirectParentName(String directParentName) {
        this.directParentName = directParentName;
    }

    @Override
    public String toString() {
        return "DepartmentMq{" +
                "Id=" + Id +
                ", departName='" + departName + '\'' +
                ", directParentId=" + directParentId +
                ", directParentName='" + directParentName + '\'' +
                ", departLevel=" + departLevel +
                ", haveChildDepart=" + haveChildDepart +
                ", docIds=" + docIds +
                ", type=" + type +
                ", grandpaDepartId=" + grandpaDepartId +
                ", grandpaDepartName='" + grandpaDepartName + '\'' +
                '}';
    }

    public DepartmentMq(String departName) {
        this.departName = departName;
    }

    public DepartmentMq() {
    }
}
