package com.expense.Sulaah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.entity.Dto.CreateUserRequest;
import com.expense.Sulaah.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apis/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	private ResponseEntity<?> getUser(@PathVariable int id) {
		try {
			User user = userService.getUser(id);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Get: " + e.getMessage());
		}
	}

	@PostMapping("/")
	private ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) {
		if (userService.existsByUsername(request.getUsername())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Username already exist");
		}
		if (userService.existsByEmail(request.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Email already exist");
		}
		// create new user
		User user = User.builder()
				.username(request.getUsername())
				.email(request.getEmail())
				.build();
				userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
	}

	@PutMapping("/{id}")
	private ResponseEntity<?> updateUserDetails(@PathVariable int id, @RequestParam String username) {
		try {
			User updatedUser = userService.updateUserDetails(id, username);
			return ResponseEntity.ok(updatedUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update: " + e.getMessage());
		}
	}
}
