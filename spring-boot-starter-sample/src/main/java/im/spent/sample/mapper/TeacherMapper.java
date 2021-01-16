package im.spent.sample.mapper;

import im.spent.sample.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Delete("DELETE FROM teacher\n" +
            "WHERE id = #{id}")
    void delete(Long id);

    @Insert("INSERT INTO teacher(id, name, username, email, sex, create_time, update_time)\n" +
            "VALUES(#{id}, #{name}, #{username}, #{email}, #{sex}, #{createTime}, #{updateTime})")
    void insert(Teacher teacher);

    @Select("SELECT id, name, username, email, sex, create_time, update_time\n" +
            "FROM teacher")
    List<Teacher> select();

    @Update("UPDATE teacher\n" +
            "SET name = #{name}, email = #{email}, sex = #{sex}, update_time = #{updateTime}\n" +
            "WHERE id = #{id}")
    void update(Teacher teacher);
}
