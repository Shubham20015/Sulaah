package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
