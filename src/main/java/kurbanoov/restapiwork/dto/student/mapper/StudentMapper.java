package kurbanoov.restapiwork.dto.student.mapper;

import kurbanoov.restapiwork.dto.conver.Convert;
import kurbanoov.restapiwork.dto.student.StudentRequestDto;
import kurbanoov.restapiwork.dto.student.StudentResponse;
import kurbanoov.restapiwork.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Convert<Student, StudentRequestDto, StudentResponse> {
    @Override
    public Student convert(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setFirstName(studentRequestDto.getFirstName());
        student.setEmail(studentRequestDto.getEmail());
        student.setStudyFormat(studentRequestDto.getStudyFormat());
        student.setGroup(studentRequestDto.getGroup());
        return student;
    }

    @Override
    public StudentResponse deConvert(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setId(student.getId());
        studentResponse.setStudyFormat(student.getStudyFormat());
        studentResponse.setGroupId(student.getGroup().getId());
        return studentResponse;
    }
}
