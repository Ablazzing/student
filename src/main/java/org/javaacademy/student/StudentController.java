package org.javaacademy.student;

import lombok.RequiredArgsConstructor;
import org.javaacademy.student.dto.StudentDto;
import org.javaacademy.student.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getStudentById(@RequestParam String name, @RequestParam String lastName) {
        return studentService.findByName(name, lastName);
    }
}
