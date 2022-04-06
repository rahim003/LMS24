package kurbanoov.restapiwork.dto.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kurbanoov.restapiwork.entity.Company;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseRequestDto {
    @NotBlank
    private String courseName;
    @NotNull
    private String duration;
    @JsonIgnore
    private Company company;
    private Long companyId;
}
