package im.spent.sample.mapper;

import im.spent.sample.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("SELECT id, name, username, email, sex, create_time, update_time\n" +
            "FROM teacher")
    List<Teacher> select();

    @Insert("INSERT INTO teacher(id, name, username, email, sex, create_time, update_time)\n" +
            "VALUES(#{id}, #{name}, #{username}, #{email}, #{sex}, #{createTime}, #{updateTime})")
    void insert(Teacher teacher);
}
