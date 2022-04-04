package kurbanoov.restapiwork.service;

import kurbanoov.restapiwork.dto.student.GetStudentDto;
import kurbanoov.restapiwork.dto.student.StudentRequestDto;
import kurbanoov.restapiwork.dto.student.StudentResponse;
import kurbanoov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanoov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanoov.restapiwork.dto.teacher.TeacherResponse;

import java.util.List;

public interface StudentService {
    StudentResponse save(StudentRequestDto studentRequestDto);

    List<StudentResponse> findAll();

    GetStudentDto findBy(Long id);

    StudentResponse update(Long id, StudentRequestDto studentRequestDto);

    void deleteById(Long id);

    StudentResponse getById(Long id);
}
