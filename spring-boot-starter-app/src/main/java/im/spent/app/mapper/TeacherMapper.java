package im.spent.app.mapper;

import im.spent.app.entity.Teacher;
import im.spent.mybatis.MySqlCoreMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper extends MySqlCoreMapper<Teacher> {
}
