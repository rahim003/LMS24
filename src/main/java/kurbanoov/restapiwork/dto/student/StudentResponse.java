package kurbanoov.restapiwork.dto.student;

import kurbanoov.restapiwork.entity.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String email;
    private Long groupId;
    private StudyFormat studyFormat;
}
