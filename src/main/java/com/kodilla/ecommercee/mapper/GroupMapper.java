package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
    @Autowired
    private ProductMapper productMapper;

    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(
                groupDto.getName());
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                productMapper.mapToProductDtoList(group.getProducts()));
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupList) {
        return groupList.stream()
                .map(g -> new GroupDto(g.getId(), g.getName(), productMapper.mapToProductDtoList(g.getProducts())))
                .collect(Collectors.toList());
    }
}
