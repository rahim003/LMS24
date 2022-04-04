package kurbanoov.restapiwork.dto.student.mapper;

import kurbanoov.restapiwork.dto.student.GetStudentDto;
import kurbanoov.restapiwork.entity.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetStudentMapper implements Converter<Student, GetStudentDto> {
    @Override
    public GetStudentDto convert(Student student) {
        GetStudentDto studentDto = new GetStudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setEmail(student.getEmail());
        studentDto.setGroupId(student.getGroup().getId());
        studentDto.setStudyFormat(student.getStudyFormat());
        return studentDto;
    }
}
