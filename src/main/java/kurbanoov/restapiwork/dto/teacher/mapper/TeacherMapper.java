package kurbanoov.restapiwork.dto.teacher.mapper;

import kurbanoov.restapiwork.dto.conver.Convert;
import kurbanoov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanoov.restapiwork.dto.teacher.TeacherResponse;
import kurbanoov.restapiwork.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper implements Convert<Teacher, TeacherRequestDto, TeacherResponse> {

    @Override
    public Teacher convert(TeacherRequestDto teacherRequestDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequestDto.getFirstName());
        teacher.setLastName(teacherRequestDto.getLastName());
        teacher.setEmail(teacherRequestDto.getEmail());
        teacher.setCourse(teacherRequestDto.getCourse());
        return teacher;
    }

    @Override
    public TeacherResponse deConvert(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setEmail(teacher.getEmail());
        teacherResponse.setCourseId(teacher.getCourse().getId());
        return teacherResponse;
    }
}
