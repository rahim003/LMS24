package kurbanoov.restapiwork.service;

import kurbanoov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanoov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanoov.restapiwork.dto.teacher.TeacherResponse;

import java.util.List;
public interface TeacherService {
    TeacherResponse save(TeacherRequestDto teacherRequestDto);

    List<TeacherResponse> findAll();

    GetTeacherDto findBy(Long id);

    TeacherResponse update(Long id, TeacherRequestDto teacherRequestDto);

    void deleteById(Long id);

    TeacherResponse getById(Long id);
}
