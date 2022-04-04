package kurbanoov.restapiwork.service;

import kurbanoov.restapiwork.dto.company.CompanyRequestDto;
import kurbanoov.restapiwork.dto.company.CompanyResponse;
import kurbanoov.restapiwork.dto.company.GetCompanyDto;
import kurbanoov.restapiwork.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    CompanyResponse save(CompanyRequestDto companyRequestDto);

    List<CompanyResponse> findAll();

    GetCompanyDto findBy(Long id);

    CompanyResponse update(Long id,CompanyRequestDto companyRequestDto);

    void deleteById(Long id);
}
