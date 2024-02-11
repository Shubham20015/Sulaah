package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;

public interface UserService {
    public User createUser(User user);
    public User getUser(int userId);
	public User getUserByEmail(String email);
	public User addUserToGroup(User user, Group group);
}
