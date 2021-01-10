package im.spent.sample.transfer.teacher.select;

import com.fasterxml.jackson.annotation.JsonFormat;
import im.spent.sample.entity.Teacher;
import im.spent.core.spec.HttpResponseSpec;

import java.util.Date;

public class TeacherSelectResponse extends HttpResponseSpec<Teacher> {

    private Long id;

    private String name;

    private String username;

    private String email;

    private Boolean sex;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public TeacherSelectResponse(Teacher teacher) {
        super(teacher);
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.username = teacher.getUsername();
        this.email = teacher.getEmail();
        this.sex = teacher.getSex();
        this.createTime = teacher.getCreateTime();
        this.updateTime = teacher.getUpdateTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
