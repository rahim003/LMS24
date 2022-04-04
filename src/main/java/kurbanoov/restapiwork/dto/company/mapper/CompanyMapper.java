package kurbanoov.restapiwork.dto.company.mapper;

import kurbanoov.restapiwork.dto.company.CompanyRequestDto;
import kurbanoov.restapiwork.dto.company.CompanyResponse;
import kurbanoov.restapiwork.dto.conver.Convert;
import kurbanoov.restapiwork.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Convert<Company, CompanyRequestDto, CompanyResponse> {
    @Override
    public Company convert(CompanyRequestDto companyRequestDto) {
        Company company=new Company();
        company.setCompanyName(companyRequestDto.getCompanyName());
        company.setLocatedCountry(companyRequestDto.getLocatedCountry());
        return company;
    }

    @Override
    public CompanyResponse deConvert(Company company) {
        CompanyResponse companyResponse=new CompanyResponse();
        companyResponse.setId(company.getId());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        companyResponse.setCourse(company.getCourses());
        return companyResponse;
    }

}
