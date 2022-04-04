package kurbanoov.restapiwork.dto.company.mapper;

import kurbanoov.restapiwork.dto.company.GetCompanyDto;
import kurbanoov.restapiwork.entity.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetCompanyMapper implements Converter<Company, GetCompanyDto> {
    @Override
    public GetCompanyDto convert(Company company) {
        GetCompanyDto getCompanyDto=new GetCompanyDto();
        getCompanyDto.setCompanyName(company.getCompanyName());
        getCompanyDto.setId(company.getId());
        getCompanyDto.setLocatedCountry(company.getLocatedCountry());
        getCompanyDto.setCourseSet(company.getCourses());
        return getCompanyDto;
    }
}
