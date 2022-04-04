package kurbanoov.restapiwork.dto.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kurbanoov.restapiwork.entity.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRequestDto {
    private String groupName;
    private Course course;
    private Long courseId;
}
