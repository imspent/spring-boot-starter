package im.spent.app.transfer.teacher.create;

import im.spent.app.entity.Teacher;
import im.spent.core.exception.DataInvalidException;
import im.spent.core.spec.HttpRequestSpec;

public class TeacherCreateRequest extends HttpRequestSpec<Teacher> {

    private String name;

    private String username;

    private String email;

    private Boolean sex;

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

    @Override
    public Teacher convertToEntity() {
        Teacher teacher = new Teacher();
        teacher.setName(this.getName());
        teacher.setUsername(this.getUsername());
        teacher.setEmail(this.getEmail());
        teacher.setSex(this.getSex());
        return teacher;
    }

    @Override
    public void checkValid() throws DataInvalidException {
    }
}
