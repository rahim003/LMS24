package kurbanoov.restapiwork.service.impl;

import kurbanoov.restapiwork.dto.group.GetGroupDto;
import kurbanoov.restapiwork.dto.group.GroupRequestDto;
import kurbanoov.restapiwork.dto.group.GroupResponse;
import kurbanoov.restapiwork.dto.group.mapper.GetGroupMapper;
import kurbanoov.restapiwork.dto.group.mapper.GroupMapper;
import kurbanoov.restapiwork.entity.Course;
import kurbanoov.restapiwork.entity.Group;
import kurbanoov.restapiwork.exception.NotFoundException;
import kurbanoov.restapiwork.repository.CourseRepository;
import kurbanoov.restapiwork.repository.GroupRepository;
import kurbanoov.restapiwork.service.GroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final GetGroupMapper getGroupMapper;
    private final CourseRepository courseRepository;

    @Override
    public GroupResponse save(GroupRequestDto groupRequestDto) {
        groupRequestDto.setCourse(courseRepository.getById(groupRequestDto.getCourseId()));
        Group group = groupMapper.convert(groupRequestDto);
        Group save = groupRepository.save(group);
        log.info("successful save group:{}", group);
        return groupMapper.deConvert(save);
    }

    @Override
    public List<GroupResponse> findAll() {
        log.info("find all group:{}", getGroupMapper);
        return groupRepository.findAll().stream()
                .map(groupMapper::deConvert).toList();
    }

    @Override
    public GetGroupDto findBy(Long id) {
        if (id != null) {
            Group group = findById(id);
            log.info("successful find by Id:{}",id);
            return getGroupMapper.convert(group);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)
            );
        }
    }

    private Group findById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("client with id = %s does not exists", id)
                ));
    }


    @Override
    @Transactional
    public GroupResponse update(Long id, GroupRequestDto groupRequestDto) {
        Group group = findById(id);
        String currentGroupName = group.getGroupName();
        String newGroupName = groupRequestDto.getGroupName();
        if (!currentGroupName.equals(newGroupName)) {
            group.setGroupName(newGroupName);
        }
        log.info("successful update courseId:{}",id);
        return groupMapper.deConvert(group);
    }

    @Override
    public void deleteById(Long id) {
        Group group = groupRepository.findById(id).orElseThrow();
        group.getCourses().forEach(u -> u.getGroups().remove(group));
        courseRepository.saveAll(group.getCourses());
        groupRepository.delete(group);
    }

    @Override
    public GroupResponse getById(Long id) {
        return groupMapper.deConvert(groupRepository.getById(id));
    }
}
