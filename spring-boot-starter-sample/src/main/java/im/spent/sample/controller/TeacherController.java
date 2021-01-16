package im.spent.sample.controller;

import im.spent.sample.service.TeacherService;
import im.spent.sample.transfer.teacher.create.TeacherCreateRequest;
import im.spent.sample.transfer.teacher.select.TeacherSelectResponse;
import im.spent.sample.transfer.teacher.update.TeacherUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("create")
    public void create(@RequestBody TeacherCreateRequest request) {
        request.checkValid();
        this.teacherService.save(request);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        this.teacherService.delete(id);
    }

    @GetMapping("select")
    public List<TeacherSelectResponse> select() {
        return this.teacherService.select();
    }

    @PutMapping("update")
    public void update(@RequestBody TeacherUpdateRequest request) {
        request.checkValid();
        this.teacherService.update(request);
    }
}
