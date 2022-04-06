package kurbanoov.restapiwork.dto.teacher.mapper;

import kurbanoov.restapiwork.dto.conver.Convert;
import kurbanoov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanoov.restapiwork.dto.teacher.TeacherResponse;
import kurbanoov.restapiwork.entity.AuthInfo;
import kurbanoov.restapiwork.entity.Role;
import kurbanoov.restapiwork.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper implements Convert<Teacher, TeacherRequestDto, TeacherResponse> {

    @Override
    public Teacher convert(TeacherRequestDto teacherRequestDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequestDto.getFirstName());
        teacher.setLastName(teacherRequestDto.getLastName());
        AuthInfo authInfo=new AuthInfo();
        authInfo.setEmail(teacherRequestDto.getEmail());
        authInfo.setPassword(teacherRequestDto.getPassword());
        authInfo.setRole(Role.STUDENT);
        teacher.setAuthInfo(authInfo);
        teacher.setCourse(teacherRequestDto.getCourse());
        return teacher;
    }

    @Override
    public TeacherResponse deConvert(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setEmail(teacher.getAuthInfo().getEmail());
        teacherResponse.setCourseId(teacher.getCourse().getId());
        return teacherResponse;
    }
}
