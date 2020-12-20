package im.spent.app.controller;

import im.spent.app.service.TeacherService;
import im.spent.app.transfer.TeacherTransfer;
import im.spent.core.validate.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("create")
    public void create(@RequestBody TeacherTransfer transfer) {
        Validator.checkValid(transfer);
        this.teacherService.save(transfer);
    }
}
