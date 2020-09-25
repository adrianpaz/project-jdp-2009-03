package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.service.DbGroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EcommerceGroupTest {

    @Autowired
    private DbGroupService service;

    @Test
    public void testGetGroups() {
        //Given
        Group group1 = new Group("Ubrania");
        Group group2 = new Group("Dodatki");
        Group group3 = new Group("Biżuteria");
        Group group4 = new Group("Obuwie");
        service.saveGroup(group1);
        service.saveGroup(group2);
        service.saveGroup(group3);
        service.saveGroup(group4);

        //When
        List<Group> groups = service.getAllGropus();

        //Then
        long idGroup1 = group1.getId();
        long idGroup2 = group2.getId();
        long idGroup3 = group3.getId();
        long idGroup4 = group4.getId();
        assertEquals(groups.size(), 4);

        //CleanUp
        service.deleteGroup(idGroup1);
        service.deleteGroup(idGroup2);
        service.deleteGroup(idGroup3);
        service.deleteGroup(idGroup4);
    }

    @Test
    public void testGetGroup() {
        //Given
        Group group1 = new Group("Ubrania");

        //When
        service.saveGroup(group1);

        //Then
        long idGroup1 = group1.getId();
        Optional<Group> group = service.getGroup(idGroup1);

        assertTrue(group.isPresent());

        //CleanUp
        service.deleteGroup(idGroup1);
    }

    @Test
    public void testDeleteGroup() {
        //Given
        Group group1 = new Group("Ubrania");
        Group group2 = new Group("Dodatki");
        Group group3 = new Group("Biżuteria");
        Group group4 = new Group("Obuwie");
        service.saveGroup(group1);
        service.saveGroup(group2);
        service.saveGroup(group3);
        service.saveGroup(group4);
        long idGroup1 = group1.getId();
        long idGroup2 = group2.getId();
        long idGroup3 = group3.getId();
        long idGroup4 = group4.getId();

        //When
        service.deleteGroup(idGroup1);

        //Then
        List<Group> groups = service.getAllGropus();
        assertEquals(groups.size(), 3);

        //CleanUp
        service.deleteGroup(idGroup2);
        service.deleteGroup(idGroup3);
        service.deleteGroup(idGroup4);
    }

    @Test
    public void testUpdateGroup() {
        //Given
        Group group1 = new Group("Ubrania");
        Group group2 = new Group("Dodatki");
        Group group3 = new Group("Biżuteria");
        Group group4 = new Group("Obuwie");
        service.saveGroup(group1);
        service.saveGroup(group2);
        service.saveGroup(group3);
        service.saveGroup(group4);
        long idGroup1 = group1.getId();
        long idGroup2 = group2.getId();
        long idGroup3 = group3.getId();
        long idGroup4 = group4.getId();

        //When
        Group group5 = new Group("Zegarki");
        group5.setId(idGroup1);
        service.saveGroup(group5);
        //Then
        Optional<Group> group = service.getGroup(idGroup1);
        String groupName = group.get().getName();
        assertEquals(groupName, "Zegarki");

        //CleanUp
        service.deleteGroup(idGroup1);
        service.deleteGroup(idGroup2);
        service.deleteGroup(idGroup3);
        service.deleteGroup(idGroup4);
    }

    @Test
    public void testCreatGroup() {
        //Given
        Group group1 = new Group("Ubrania");

        //When
        service.saveGroup(group1);
        List<Group> groups = service.getAllGropus();

        //Then
        long idGroup1 = group1.getId();
        assertEquals(groups.size(), 1);

        //CleanUp
        service.deleteGroup(idGroup1);
    }
}
