package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbGroupService {
    @Autowired
    private GroupRepository repository;

    public List<Group> getAllGropus() {
        return repository.findAll();
    }

    public Optional<Group> getGroup(final Long id) {
        return repository.findById(id);
    }

    public Group saveGroup(final Group group) {
        return repository.save(group);
    }

    public void deleteGroup(final Long id) {
        repository.deleteById(id);
    }

}