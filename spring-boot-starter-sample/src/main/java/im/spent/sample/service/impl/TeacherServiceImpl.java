package im.spent.sample.service.impl;

import im.spent.sample.entity.Teacher;
import im.spent.sample.mapper.TeacherMapper;
import im.spent.sample.service.TeacherService;
import im.spent.sample.transfer.teacher.create.TeacherCreateRequest;
import im.spent.sample.transfer.teacher.select.TeacherSelectResponse;
import im.spent.core.serial.SnowFlakeWorker;
import im.spent.core.util.TimeUtils;
import im.spent.sample.transfer.teacher.update.TeacherUpdateRequest;
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
    public void delete(Long id) {
        this.teacherMapper.delete(id);
    }

    @Override
    public void save(TeacherCreateRequest request) {
        Teacher teacher = request.convertToEntity();
        teacher.setId(snowFlakeWorker.nextId());

        teacher.setCreateTime(TimeUtils.currentDateTime());
        teacher.setUpdateTime(TimeUtils.currentDateTime());

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

    @Override
    public void update(TeacherUpdateRequest request) {
        Teacher teacher = request.convertToEntity();
        teacher.setUpdateTime(TimeUtils.currentDateTime());

        this.teacherMapper.update(teacher);
    }
}
