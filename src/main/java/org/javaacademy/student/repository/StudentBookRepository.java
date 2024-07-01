package org.javaacademy.student.repository;

import org.javaacademy.student.entity.StudentBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBookRepository extends JpaRepository<StudentBook, Long> {
}
