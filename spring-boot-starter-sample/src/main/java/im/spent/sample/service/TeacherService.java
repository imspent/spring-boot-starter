package im.spent.sample.service;

import im.spent.sample.transfer.teacher.create.TeacherCreateRequest;
import im.spent.sample.transfer.teacher.select.TeacherSelectResponse;

import java.util.List;

public interface TeacherService {

    void delete(Long id);

    void save(TeacherCreateRequest request);

    List<TeacherSelectResponse> select();
}
