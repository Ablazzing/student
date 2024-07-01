package org.javaacademy.student.repository;

import org.javaacademy.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query(value = "from Student s where s.studentBook.number = :number")
    List<Student> findAllByStudentBook_Number(String number);
}
