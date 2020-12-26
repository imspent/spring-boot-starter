package im.spent.app.service;

import im.spent.app.transfer.teacher.create.TeacherCreateRequest;
import im.spent.app.transfer.teacher.select.TeacherSelectResponse;

import java.util.List;

public interface TeacherService {

    void save(TeacherCreateRequest request);

    List<TeacherSelectResponse> select();
}
