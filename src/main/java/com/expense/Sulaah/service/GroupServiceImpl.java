package com.expense.Sulaah.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public String addMembers(int groupId, List<Integer> userIdList) {
        Optional<Group> currentGroup = groupRepository.findById(groupId);

        if (!currentGroup.isPresent())
            return "Error in getting group by given groupId";
			// TODO: throw Error here

        Group group = currentGroup.get();

        List<User> existingGroupMembers = group.getUsersInGroup();
        userIdList = userIdList.stream()
                .filter(user -> !existingGroupMembers.contains(userRepository.findById(user).get()))
                .collect(Collectors.toList());

        List<User> resultUserList = userRepository.findAllById(userIdList);

        existingGroupMembers.addAll(resultUserList);

        return "Successfully added all members to group";
    }

	@Override
	public Group addUserToGroup(Group group, User user) {
		List<User> userList = group.getUsersInGroup();
		if (userList == null) {
			userList = new ArrayList<>();
		}
		userList.add(user);
		group.setUsersInGroup(userList);
		return groupRepository.save(group);
	}
}
