package im.spent.sample.transfer.teacher.update;

import im.spent.core.exception.DataInvalidException;
import im.spent.core.spec.HttpRequestSpec;
import im.spent.sample.entity.Teacher;

public class TeacherUpdateRequest extends HttpRequestSpec<Teacher> {

    private Long id;

    private String name;

    private String email;

    private Boolean sex;

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

    @Override
    public Teacher convertToEntity() {
        Teacher teacher = new Teacher();
        teacher.setId(this.getId());
        teacher.setName(this.getName());
        teacher.setEmail(this.getEmail());
        teacher.setSex(this.getSex());
        return teacher;
    }

    @Override
    public void checkValid() throws DataInvalidException {
    }
}
