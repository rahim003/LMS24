package kurbanoov.restapiwork.service;

import kurbanoov.restapiwork.dto.course.CourseRequestDto;
import kurbanoov.restapiwork.dto.course.CourseResponse;
import kurbanoov.restapiwork.dto.course.GetCourseDto;
import kurbanoov.restapiwork.dto.group.GetGroupDto;
import kurbanoov.restapiwork.dto.group.GroupRequestDto;
import kurbanoov.restapiwork.dto.group.GroupResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    GroupResponse save(GroupRequestDto groupRequestDto);

    List<GroupResponse> findAll();

    GetGroupDto findBy(Long id);

    GroupResponse update(Long id, GroupRequestDto groupRequestDto);

    void deleteById(Long id);

    GroupResponse getById(Long id);
}
