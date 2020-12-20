package im.spent.app.transfer;

import im.spent.core.spec.Validatable;
import im.spent.util.ValidateUtil;

public class TeacherTransfer implements Validatable {

    private String name;

    private String username;

    private String email;

    private Boolean sex;

    public TeacherTransfer() {
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

    @Override
    public boolean valid() {
        return ValidateUtil.isNotBlank(name)
                && ValidateUtil.isNotBlank(username)
                && ValidateUtil.isNotBlank(email)
                && ValidateUtil.isNotNull(sex);
    }
}
