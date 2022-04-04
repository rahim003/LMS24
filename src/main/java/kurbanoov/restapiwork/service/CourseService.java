package kurbanoov.restapiwork.service;

import kurbanoov.restapiwork.dto.course.CourseRequestDto;
import kurbanoov.restapiwork.dto.course.CourseResponse;
import kurbanoov.restapiwork.dto.course.GetCourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    CourseResponse save(CourseRequestDto courseRequestDto);

    List<CourseResponse> findAll();

    GetCourseDto findBy(Long id);

    CourseResponse update(Long id, CourseRequestDto courseRequestDto);

    void deleteById(Long id);

}
