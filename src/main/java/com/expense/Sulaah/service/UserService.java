package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.User;

public interface UserService {
    public User createUser(User user);
    public User getUser(int userId);
}
