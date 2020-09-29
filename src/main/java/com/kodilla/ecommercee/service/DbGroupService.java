package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbGroupService {
    @Autowired
    private GroupRepository repository;

    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public Optional<Group> getGroup(final Long id) {
        return repository.findById(id);
    }

    public Group saveGroup(final Group group) {
        return repository.save(group);
    }

    public void updateGroup(final GroupDto groupDto) {
        Long groupId = groupDto.getId();
        String name = groupDto.getName();
        try {
            Group group = getGroup(groupId).orElseThrow(GroupNotFoundException::new);
            group.setName(name);
            saveGroup(group);
        } catch (Exception e) {

        }
    }

    public void deleteGroup(final Long id) {
        repository.deleteById(id);
    }
}