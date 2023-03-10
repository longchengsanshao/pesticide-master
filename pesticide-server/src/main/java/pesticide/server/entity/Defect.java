package pesticide.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Defect {//缺陷实体类

    @Id
    @GeneratedValue
    private Integer id;//缺陷Id
    private Integer submitUserId;//提交者Id
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;//提交时间
    private String title;//缺陷标题
    private String description;//缺陷描述
    private DefectState defectState;//缺陷状态(已解决，未解决，已提交等)
    private Integer projectId;//缺陷所属项目Id
    private Integer resolveUserId;//缺陷处理人Id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(Integer submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DefectState getDefectState() {
        return defectState;
    }

    public void setDefectState(DefectState defectState) {
        this.defectState = defectState;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getResolveUserId() {
        return resolveUserId;
    }

    public void setResolveUserId(Integer resolveUserId) {
        this.resolveUserId = resolveUserId;
    }
}
