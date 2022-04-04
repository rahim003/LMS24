package kurbanoov.restapiwork.repository;

import kurbanoov.restapiwork.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
}