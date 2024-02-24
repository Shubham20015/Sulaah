package com.expense.Sulaah.service;

import java.util.Optional;

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
	public User getUserByEmail(String email) throws NullPointerException {
		Optional<User> user = userRepository.findByEmailIgnoreCase(email);
		if (!user.isPresent()) {
			throw new NullPointerException("No user find with given email: " + email);
		}
		return user.get();
	}
}
