package turkcell.libaryspringboot.libary.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import turkcell.libaryspringboot.libary.dto.LoginRequest;
import turkcell.libaryspringboot.libary.dto.RegisterRequest;
import turkcell.libaryspringboot.libary.service.StudentServiceImpl;

@RequestMapping("api/students")
@RestController
public class StudentsController {
private final StudentServiceImpl studentService;

    public StudentsController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void register(@RequestBody @Valid RegisterRequest registerRequest)
    {
        this.studentService.registerUser(registerRequest);
    }
    @PostMapping("login")
    public String login(@RequestBody @Valid LoginRequest loginRequest)
    {
        return this.studentService.login(loginRequest);
    }
}
