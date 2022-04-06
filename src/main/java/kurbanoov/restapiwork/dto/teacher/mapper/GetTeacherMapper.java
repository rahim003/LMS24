package kurbanoov.restapiwork.dto.teacher.mapper;

import kurbanoov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanoov.restapiwork.entity.Teacher;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetTeacherMapper implements Converter<Teacher,GetTeacherDto> {
    @Override
    public GetTeacherDto convert(Teacher teacher) {
        GetTeacherDto getTeacherDto=new GetTeacherDto();
        getTeacherDto.setId(teacher.getId());
        getTeacherDto.setFirstName(teacher.getFirstName());
        getTeacherDto.setLastName(teacher.getLastName());
        getTeacherDto.setEmail(teacher.getAuthInfo().getEmail());
        getTeacherDto.setCourseId(teacher.getCourse().getId());
        return getTeacherDto;
    }
}
