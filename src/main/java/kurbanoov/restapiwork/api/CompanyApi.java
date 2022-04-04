package kurbanoov.restapiwork.api;

import kurbanoov.restapiwork.dto.company.CompanyRequestDto;
import kurbanoov.restapiwork.dto.company.CompanyResponse;
import kurbanoov.restapiwork.dto.company.GetCompanyDto;
import kurbanoov.restapiwork.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/company")
public class CompanyApi {
    private CompanyService companyService;

    @PostMapping("/save")
    public CompanyResponse save(@RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.save(companyRequestDto);
    }
    @GetMapping
    public List<CompanyResponse> findAll() {
        return companyService.findAll();
    }

    @GetMapping("find/by/{id}")
    public GetCompanyDto findBy(@PathVariable Long id) {
        return companyService.findBy(id);
    }

    @PatchMapping("update/{id}")
    public CompanyResponse update(@PathVariable Long id, @RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.update(id, companyRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        companyService.deleteById(id);
    }
}
