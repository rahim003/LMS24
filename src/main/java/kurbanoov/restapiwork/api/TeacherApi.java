package kurbanoov.restapiwork.api;

import kurbanoov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanoov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanoov.restapiwork.dto.teacher.TeacherResponse;
import kurbanoov.restapiwork.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teacher")
@AllArgsConstructor
public class TeacherApi {
    private final TeacherService teacherService;

    @PostMapping("/save")
    public TeacherResponse saveTeacher(@RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherService.save(teacherRequestDto);
    }

    @GetMapping
    public List<TeacherResponse> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/find/{id}")
    public GetTeacherDto getById(@PathVariable Long id) {
        return teacherService.findBy(id);
    }

    @PatchMapping("/update/{id}")
    public TeacherResponse updateTeacher(@PathVariable Long id, @RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherService.update(id, teacherRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        teacherService.deleteById(id);
    }
}
