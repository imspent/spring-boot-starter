package im.spent.app.mapper;

import im.spent.app.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {

    void insert(Teacher teacher);
}
