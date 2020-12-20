package im.spent.app.service.impl;

import im.spent.app.entity.Teacher;
import im.spent.app.mapper.TeacherMapper;
import im.spent.app.service.TeacherService;
import im.spent.app.transfer.TeacherTransfer;
import im.spent.core.serial.SnowFlakeWorker;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;
    private final SnowFlakeWorker snowFlakeWorker;

    public TeacherServiceImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") TeacherMapper teacherMapper, SnowFlakeWorker snowFlakeWorker) {
        this.teacherMapper = teacherMapper;
        this.snowFlakeWorker = snowFlakeWorker;
    }

    @Override
    public void save(TeacherTransfer transfer) {
        Teacher teacher = new Teacher();
        teacher.setId(snowFlakeWorker.nextId());
        teacher.setName(transfer.getName());
        teacher.setUsername(transfer.getUsername());
        teacher.setEmail(transfer.getEmail());
        teacher.setSex(transfer.getSex());

        teacher.setCreateTime(Calendar.getInstance());
        teacher.setUpdateTime(Calendar.getInstance());

        this.teacherMapper.insert(teacher);
    }
}
