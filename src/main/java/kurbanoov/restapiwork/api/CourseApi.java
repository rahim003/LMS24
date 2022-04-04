package kurbanoov.restapiwork.api;

import kurbanoov.restapiwork.dto.course.CourseRequestDto;
import kurbanoov.restapiwork.dto.course.CourseResponse;
import kurbanoov.restapiwork.dto.course.GetCourseDto;
import kurbanoov.restapiwork.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/course")
public class CourseApi {
    private final CourseService courseService;

    @PostMapping("/save")
    public CourseResponse saveCourse(@RequestBody CourseRequestDto courseRequestDto) {
        return courseService.save(courseRequestDto);
    }

    @GetMapping
    public List<CourseResponse> findAllCourse() {
        return courseService.findAll();
    }

    @GetMapping("find/{id}")
    public GetCourseDto findByIdCourse(@PathVariable Long id) {
        return courseService.findBy(id);
    }

    @PatchMapping("update/{id}")
    public CourseResponse update(@PathVariable Long id, @RequestBody CourseRequestDto courseRequestDto) {
        return courseService.update(id, courseRequestDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteByIdCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
