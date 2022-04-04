package kurbanoov.restapiwork.service.impl;

import kurbanoov.restapiwork.dto.course.CourseRequestDto;
import kurbanoov.restapiwork.dto.course.CourseResponse;
import kurbanoov.restapiwork.dto.course.GetCourseDto;
import kurbanoov.restapiwork.dto.course.mapper.CourseMapper;
import kurbanoov.restapiwork.dto.course.mapper.GetCourseMapper;
import kurbanoov.restapiwork.entity.Course;
import kurbanoov.restapiwork.exception.NotFoundException;
import kurbanoov.restapiwork.repository.CompanyRepository;
import kurbanoov.restapiwork.repository.CourseRepository;
import kurbanoov.restapiwork.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseMapper courseMapper;
    private final GetCourseMapper getCourseMapper;

    @Override
    public CourseResponse save(CourseRequestDto courseRequestDto) {
        courseRequestDto.setCompany(companyRepository.getById(courseRequestDto.getCompanyId()));
        Course course = courseMapper.convert(courseRequestDto);
        Course save = courseRepository.save(course);
        log.info("successful save course:{}",course);
        return courseMapper.deConvert(save);

    }

    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map(courseMapper::deConvert).toList();
    }

    @Override
    public GetCourseDto findBy(Long id) {
        if (id != null) {
            Course course = findById(id);
            log.info("successful find by id:{}",id);
            return getCourseMapper.convert(course);
        }else {
            throw new NotFoundException(
                    String.format("not found=%s id",id)
            );
        }
    }

    private Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("client with id = %s does not exists", id)
                ));
    }


    @Override
    @Transactional
    public CourseResponse update(Long id, CourseRequestDto courseRequestDto) {
        Course course = findById(id);
        String currentCourseName = course.getCourseName();
        String newCourseName = courseRequestDto.getCourseName();
        if (!currentCourseName.equals(newCourseName)) {
            course.setCourseName(newCourseName);
        }
        String currenDuration = course.getDuration();
        String newDuration = courseRequestDto.getDuration();
        if (!currenDuration.equals(newDuration)) {
            course.setDuration(newDuration);
        }
        log.info("successful update course id:{}",id);
        return courseMapper.deConvert(course);
    }

    @Override
    public void deleteById(Long id) {
        log.info("successful delete by id course:{}",id);
        courseRepository.deleteById(id);

    }

}
