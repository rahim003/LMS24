package kurbanoov.restapiwork.dto.student;

import kurbanoov.restapiwork.entity.Group;
import kurbanoov.restapiwork.entity.StudyFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentRequestDto {
    private String firstName;
    @Email
    private String email;
    private Group group;
    private Long groupId;
    private StudyFormat studyFormat;
}
