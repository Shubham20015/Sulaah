package com.expense.Sulaah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	private User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	@PostMapping()
	public User addUser(@RequestBody User user) {
		userService.addUser(user);
		return user;
	}
}
