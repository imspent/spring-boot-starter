package im.spent.app.controller;

import im.spent.app.service.TeacherService;
import im.spent.app.transfer.teacher.create.TeacherCreateRequest;
import im.spent.app.transfer.teacher.select.TeacherSelectResponse;
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

    @GetMapping("select")
    public List<TeacherSelectResponse> select() {
        return this.teacherService.select();
    }
}
