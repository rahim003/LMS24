package kurbanoov.restapiwork.service.impl;

import kurbanoov.restapiwork.dto.student.GetStudentDto;
import kurbanoov.restapiwork.dto.student.StudentRequestDto;
import kurbanoov.restapiwork.dto.student.StudentResponse;
import kurbanoov.restapiwork.dto.student.mapper.GetStudentMapper;
import kurbanoov.restapiwork.dto.student.mapper.StudentMapper;
import kurbanoov.restapiwork.entity.Student;
import kurbanoov.restapiwork.entity.StudyFormat;
import kurbanoov.restapiwork.exception.BadRequestException;
import kurbanoov.restapiwork.exception.NotFoundException;
import kurbanoov.restapiwork.repository.GroupRepository;
import kurbanoov.restapiwork.repository.StudentRepository;
import kurbanoov.restapiwork.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GetStudentMapper getStudentMapper;
    private final GroupRepository groupRepository;

    @Override
    public StudentResponse save(StudentRequestDto studentRequestDto) {
        String email = studentRequestDto.getEmail();
        boolean exists = studentRepository.existsByEmail(email);
        if (exists) {
            throw new BadRequestException(
                    String.format("student with email = %s has already exists", email)
            );
        }
        studentRequestDto.setGroup(groupRepository.getById(studentRequestDto.getGroupId()));
        Student student = studentMapper.convert(studentRequestDto);
        Student save = studentRepository.save(student);
        return studentMapper.deConvert(save);
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::deConvert).toList();
    }

    @Override
    public GetStudentDto findBy(Long id) {
        if (id != null) {
            Student student = findById(id);
            return getStudentMapper.convert(student);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)
            );
        }
    }

    private Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("student with id = %s does not exists", id)
                ));
    }

    @Override
    @Transactional
    public StudentResponse update(Long id, StudentRequestDto studentRequestDto) {
        Student student = findById(id);
        String currents = student.getFirstName();
        String newFirstName = studentRequestDto.getFirstName();
        if (!currents.equals(newFirstName)) {
            student.setFirstName(newFirstName);
        }
        String currentEmail = student.getEmail();
        String newEmail = studentRequestDto.getEmail();
        if (!currentEmail.equals(newEmail)) {
            student.setEmail(newEmail);
        }
        StudyFormat concurrent = student.getStudyFormat();
        StudyFormat format = studentRequestDto.getStudyFormat();
        if (!concurrent.equals(format)) {
            student.setStudyFormat(format);
        }

        return studentMapper.deConvert(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse getById(Long id) {
        return studentMapper.deConvert(studentRepository.getById(id));
    }
}
