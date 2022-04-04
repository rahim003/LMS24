package kurbanoov.restapiwork.repository;

import kurbanoov.restapiwork.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
