package com.expense.Sulaah.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.repository.GroupRepository;
import com.expense.Sulaah.repository.UserRepository;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Group createGroup(int userId, Group group) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<User> usersInGroupList = group.getUsersInGroup();
            if (usersInGroupList == null) {
                usersInGroupList = new ArrayList<User>();
                group.setUsersInGroup(usersInGroupList);
            }
            usersInGroupList.add(user.get());
            return groupRepository.save(group);
        } else {
            return null;
        }
    }

    @Override
    public Group getGroupById(int groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    @Override
    public String addMembers(int groupId, List<User> users) {
        Optional<Group> group = groupRepository.findById(groupId);

        if (!group.isPresent())
            return "Error in getting group by given groupId";

        group
                .get()
                .getUsersInGroup()
                .addAll(users);

        return "Successfully added all members to group";
    }
}
