package kurbanoov.restapiwork.api;

import kurbanoov.restapiwork.dto.student.GetStudentDto;
import kurbanoov.restapiwork.dto.student.StudentRequestDto;
import kurbanoov.restapiwork.dto.student.StudentResponse;
import kurbanoov.restapiwork.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentApi {
    private final StudentService studentService;

    @PostMapping("/save")
    public StudentResponse saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.save(studentRequestDto);
    }

    @GetMapping()
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    @PatchMapping("update/{id}")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.update(id, studentRequestDto);
    }

    @GetMapping("find/{id}")
    public GetStudentDto getById(@PathVariable Long id) {
        return studentService.findBy(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
