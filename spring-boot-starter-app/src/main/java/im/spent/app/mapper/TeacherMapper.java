package im.spent.app.mapper;

import im.spent.app.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {

    @Insert("INSERT INTO teacher(id, name, username, email, sex, create_time, update_time)\n" +
            "VALUES(#{id}, #{name}, #{username}, #{email}, #{sex}, #{createTime}, #{updateTime})")
    void insert(Teacher teacher);
}
