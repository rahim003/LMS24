package kurbanoov.restapiwork.repository;

import kurbanoov.restapiwork.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    boolean existsByEmail(String email);

}