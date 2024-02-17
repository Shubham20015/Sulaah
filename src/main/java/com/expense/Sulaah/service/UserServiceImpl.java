package com.expense.Sulaah.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(int userId) throws RuntimeException{
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        return user;
    }

    @Override
    public User updateUserDetails(int userId, String userName) throws RuntimeException {
        User user = getUser(userId);
        user.setUsername(userName);

        return userRepository.save(user);
    }

	@Override
	public User getUserByEmail(String email) {
		List<User> users = userRepository.findDistinctByEmailIgnoreCase(email);
		if (users.isEmpty()) {
			System.out.println("############################### NO USER FOUND");
			return null;
		}
		return users.get(0);
	}

	@Override
	public User addUserToGroup(User user, Group group) {
		List<Group> userGroupList = user.getGroups();
		if (userGroupList == null) {
			userGroupList = new ArrayList<>();
		}
		userGroupList.add(group);
		user.setGroups(userGroupList);
		return userRepository.save(user);
	}
}
