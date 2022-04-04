package kurbanoov.restapiwork.dto.course.mapper;

import kurbanoov.restapiwork.dto.course.GetCourseDto;
import kurbanoov.restapiwork.entity.Course;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetCourseMapper  implements Converter<Course, GetCourseDto> {
    @Override
    public GetCourseDto convert(Course course) {
        GetCourseDto getCourseDto=new GetCourseDto();
        getCourseDto.setCourseName(course.getCourseName());
        getCourseDto.setId(course.getId());
        getCourseDto.setDuration(course.getDuration());
        getCourseDto.setCompanyId(course.getCompany().getId());
        return getCourseDto;
    }
}
