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
    public Group createGroup(int userId, String name) throws SecurityException {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
			throw new SecurityException("User not present with given id: " + userId);
        }

		Group newGroup = new Group();
		newGroup.setName(name);

		List<User> listOfUsers = new ArrayList<>();
		listOfUsers.add(user.get());
		newGroup.setUsersInGroup(listOfUsers);

		return groupRepository.save(newGroup);
    }

    @Override
    public Group getGroupById(int groupId) throws RuntimeException {
		Optional<Group> group = groupRepository.findById(groupId);
		if(!group.isPresent()){
			throw new RuntimeException("Group not found with ID: " + groupId);
		}

        return group.get();
    }

    @Override
    public Group addMembers(int groupId, List<Integer> userIdList) throws RuntimeException {
        Optional<Group> groupDB = groupRepository.findById(groupId);

        if (groupDB.isEmpty())
			throw new RuntimeException("Group not found with ID: " + groupId);

		Group currentGroup = groupDB.get();

		List<User> existingGroupMembers = currentGroup.getUsersInGroup();

		List<Integer> groupMemberIdList = existingGroupMembers
												.stream()
												.map(User::getId)
												.toList();

		userIdList = userIdList.stream()
								.filter(userId -> !groupMemberIdList.contains(userId))
								.collect(Collectors.toList());

		List<User> resultUserList = userRepository.findAllById(userIdList);
		existingGroupMembers.addAll(resultUserList);
		currentGroup.setUsersInGroup(existingGroupMembers);

        return groupRepository.save(currentGroup);
    }
}
