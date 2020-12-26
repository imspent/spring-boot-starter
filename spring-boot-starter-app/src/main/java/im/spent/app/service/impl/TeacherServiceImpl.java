package im.spent.app.service.impl;

import im.spent.app.entity.Teacher;
import im.spent.app.mapper.TeacherMapper;
import im.spent.app.service.TeacherService;
import im.spent.app.transfer.teacher.create.TeacherCreateRequest;
import im.spent.app.transfer.teacher.select.TeacherSelectResponse;
import im.spent.core.serial.SnowFlakeWorker;
import im.spent.core.util.TimeUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;
    private final SnowFlakeWorker snowFlakeWorker;

    public TeacherServiceImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") TeacherMapper teacherMapper, SnowFlakeWorker snowFlakeWorker) {
        this.teacherMapper = teacherMapper;
        this.snowFlakeWorker = snowFlakeWorker;
    }

    @Override
    public void save(TeacherCreateRequest request) {
        Teacher teacher = request.convertToEntity();
        teacher.setId(snowFlakeWorker.nextId());

        teacher.setCreateTime(TimeUtils.currentDatetime());
        teacher.setUpdateTime(TimeUtils.currentDatetime());

        this.teacherMapper.insert(teacher);
    }

    @Override
    public List<TeacherSelectResponse> select() {
        List<Teacher> teachers = this.teacherMapper.select();
        List<TeacherSelectResponse> responses = new ArrayList<>();

        for (Teacher teacher : teachers) {
            TeacherSelectResponse response = new TeacherSelectResponse(teacher);
            responses.add(response);
        }
        return responses;
    }
}
