package kurbanoov.restapiwork.api;

import kurbanoov.restapiwork.dto.group.GetGroupDto;
import kurbanoov.restapiwork.dto.group.GroupRequestDto;
import kurbanoov.restapiwork.dto.group.GroupResponse;
import kurbanoov.restapiwork.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/group")
public class GroupApi {
    private final GroupService groupService;

    @PostMapping("/save")

    public GroupResponse saveGroup(@RequestBody GroupRequestDto groupRequestDto) {
        return groupService.save(groupRequestDto);
    }

    @GetMapping
    public List<GroupResponse> findAllGroups() {
        return groupService.findAll();
    }

    @GetMapping("find/{id}")
    public GetGroupDto findByIdGroup(@PathVariable Long id) {
        return groupService.findBy(id);
    }

    @PatchMapping("update/{id}")
    public GroupResponse update(@PathVariable Long id, @RequestBody GroupRequestDto groupRequestDto) {
        return groupService.update(id, groupRequestDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteByIdGroup(@PathVariable Long id) {
        groupService.deleteById(id);
    }

}
