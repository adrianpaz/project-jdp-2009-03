package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.DbGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/group")
public class GroupController {
    @Autowired
    private DbGroupService service;

    @Autowired
    private GroupMapper groupMapper;

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(service.getAllGroups());
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(service.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) {
        service.deleteGroup(groupId);
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) throws GroupNotFoundException {
        service.updateGroup(groupDto);
        return getGroup(groupDto.getId());
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        service.saveGroup(groupMapper.mapToGroup(groupDto));
    }
}
