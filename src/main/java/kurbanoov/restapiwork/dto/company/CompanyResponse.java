package kurbanoov.restapiwork.dto.company;

import kurbanoov.restapiwork.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private List<Course> course;
}
