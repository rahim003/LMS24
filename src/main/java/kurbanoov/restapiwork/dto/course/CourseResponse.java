package kurbanoov.restapiwork.dto.course;

import kurbanoov.restapiwork.entity.Group;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String courseName;
    private String duration;
    private List<Group> group;
}
