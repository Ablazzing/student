package org.javaacademy.student.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.student.dto.StudentDto;
import org.javaacademy.student.entity.Student;
import org.javaacademy.student.entity.StudentBook;
import org.javaacademy.student.mapper.StudentMapper;
import org.javaacademy.student.repository.StudentBookRepository;
import org.javaacademy.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentBookRepository studentBookRepository;
    private final StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init() {

        Student student = new Student();
        student.setFirstName("Yuri");
        student.setLastName("Molodyko");

        StudentBook studentBook = new StudentBook();
        studentBook.setNumber("123");
        studentBook.setStudent(student);

        Student student2 = new Student();
        student2.setFirstName("Petr");
        student2.setLastName("Ivanov");
        studentBookRepository.save(studentBook);
        studentRepository.saveAll(List.of(student, student2));
        List<StudentDto> byName = studentService.findByName("Petr", "Ivanov");
        if (true) {
            throw new RuntimeException("Hop");
        }
    }

    @Transactional
    public List<StudentDto> findByName(String name, String lastName) {
        Student student2 = new Student();
        student2.setFirstName("Petr");
        student2.setLastName("Zirov");
        studentRepository.save(student2);

        return studentRepository.findAllByStudentBook_Number("123").stream().map(studentMapper::convertToDto).toList();
    }
}
