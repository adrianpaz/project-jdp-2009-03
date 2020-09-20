package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/group")
public class GroupController {

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        List<GroupDto> groups = new ArrayList<>();
        groups.add(new GroupDto(1L, "Ubrania"));
        groups.add(new GroupDto(2L, "Dodatki"));
        groups.add(new GroupDto(3L, "Biżuteria"));
        groups.add(new GroupDto(4L, "Obuwie"));
        return new ArrayList<>(groups);
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) {
        return new GroupDto(1L, "Ubrania");
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) {

    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto(1L, "Kosmetyki");
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {

    }
}
