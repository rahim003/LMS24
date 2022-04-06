package kurbanoov.restapiwork.api;

import io.swagger.v3.oas.annotations.Operation;
import kurbanoov.restapiwork.dto.company.CompanyRequestDto;
import kurbanoov.restapiwork.dto.company.CompanyResponse;
import kurbanoov.restapiwork.dto.company.GetCompanyDto;
import kurbanoov.restapiwork.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/company")
public class CompanyApi {
    private CompanyService companyService;

    @PostMapping("/save")
    @Operation(summary = "save company ",description = "save company")
    @PreAuthorize("hasAuthority('ADMIN')")
    public CompanyResponse save(@RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.save(companyRequestDto);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
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
