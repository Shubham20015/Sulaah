package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.User;

public interface UserService {
    User createUser(User user);
    User getUser(int userId);
	User updateUserDetails(int userId, String userName) throws RuntimeException;
	User getUserByEmail(String email) throws NullPointerException;
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
}
