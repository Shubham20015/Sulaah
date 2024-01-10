package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;
    @Override
    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroup(int groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    @Override
    public String addMembers(int groupId, List<User> users) {
        Optional<Group> group = groupRepository.findById(groupId);

        if(!group.isPresent()) return "Error in getting group by given groupId";

        group
            .get()
            .getUsersInGroup()
            .addAll(users);

        return "Successfully added all members to group";
    }
}