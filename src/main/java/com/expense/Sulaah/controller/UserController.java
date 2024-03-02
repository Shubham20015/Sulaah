package com.expense.Sulaah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.service.UserService;

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
	private User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	private ResponseEntity<?> updateUserDetails(@PathVariable int id, @RequestParam String username){
		try {
			User updatedUser = userService.updateUserDetails(id, username);
			return ResponseEntity.ok(updatedUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update: " + e.getMessage());
		}
	}
}
