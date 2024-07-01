package org.javaacademy.student.mapper;

import org.javaacademy.student.dto.StudentDto;
import org.javaacademy.student.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto convertToDto(Student entity);
}
