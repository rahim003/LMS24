package kurbanoov.restapiwork.service.impl;

import kurbanoov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanoov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanoov.restapiwork.dto.teacher.TeacherResponse;
import kurbanoov.restapiwork.dto.teacher.mapper.GetTeacherMapper;
import kurbanoov.restapiwork.dto.teacher.mapper.TeacherMapper;
import kurbanoov.restapiwork.entity.Teacher;
import kurbanoov.restapiwork.exception.BadRequestException;
import kurbanoov.restapiwork.exception.NotFoundException;
import kurbanoov.restapiwork.repository.CourseRepository;
import kurbanoov.restapiwork.repository.TeacherRepository;
import kurbanoov.restapiwork.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final GetTeacherMapper getTeacherMapper;
    private final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TeacherResponse save(TeacherRequestDto teacherRequestDto) {
//        String email = teacherRequestDto.getEmail();
//        boolean exists = teacherRepository.existsByAndAuthInfoEmail(email);
//        if (exists) {
//            throw new BadRequestException(
//                    String.format("student with email = %s has already exists", email)
//            );
//        }
        String encoderPassword=passwordEncoder.encode(teacherRequestDto.getPassword());
        teacherRequestDto.setPassword(encoderPassword);
            teacherRequestDto.setCourse(courseRepository.getById(teacherRequestDto.getCourseId()));
            Teacher teacher = teacherMapper.convert(teacherRequestDto);
            Teacher save = teacherRepository.save(teacher);
            return teacherMapper.deConvert(save);
    }

    @Override
    public List<TeacherResponse> findAll() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::deConvert).toList();
    }

    @Override
    public GetTeacherDto findBy(Long id) {
        if (id != null) {
            Teacher teacher = findById(id);
            return getTeacherMapper.convert(teacher);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)

            );
        }
    }

    private Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("teacher with id = %s does not exists", id)
                ));
    }
    @Override
    @Transactional
    public TeacherResponse update(Long id, TeacherRequestDto teacherRequestDto) {
        Teacher teacher = findById(id);
        String currentFirstName = teacher.getFirstName();
        String newFirstName = teacherRequestDto.getFirstName();
        if (!currentFirstName.equals(newFirstName)) {
            teacher.setFirstName(newFirstName);
        }
        String currentLastName = teacher.getLastName();
        String newLastName = teacherRequestDto.getLastName();
        if (!currentLastName.equals(newLastName)) {
            teacher.setLastName(newLastName);
        }
        return teacherMapper.deConvert(teacher);
    }
    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherResponse getById(Long id) {
        return teacherMapper.deConvert(teacherRepository.getById(id));

    }
}
