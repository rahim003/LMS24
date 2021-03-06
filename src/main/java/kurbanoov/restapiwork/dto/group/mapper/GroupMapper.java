package kurbanoov.restapiwork.dto.group.mapper;

import kurbanoov.restapiwork.dto.conver.Convert;
import kurbanoov.restapiwork.dto.group.GroupRequestDto;
import kurbanoov.restapiwork.dto.group.GroupResponse;
import kurbanoov.restapiwork.entity.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements Convert<Group, GroupRequestDto, GroupResponse> {
    @Override
    public Group convert(GroupRequestDto groupRequestDto) {
        Group group = new Group();
        group.setGroupName(groupRequestDto.getGroupName());
        group.setCourse(groupRequestDto.getCourse());
        return group;
    }

    @Override
    public GroupResponse deConvert(Group group) {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setId(group.getId());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        groupResponse.setStudent(group.getStudents());
        return groupResponse;
    }
}
