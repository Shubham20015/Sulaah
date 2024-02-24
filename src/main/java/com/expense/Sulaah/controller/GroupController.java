package com.expense.Sulaah.controller;

import com.expense.Sulaah.entity.Dto.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.service.GroupService;

@RestController
@RequestMapping("/apis/group")
public class GroupController {
	@Autowired
	private GroupService groupService;

	@GetMapping("/{id}")
	private ResponseEntity<?> getGroup(@PathVariable int id) {
		try {
			Group group = groupService.getGroupById(id);
			return ResponseEntity.ok(group);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Get: " + e.getMessage());
		}
	}

	@PostMapping("/{userId}")
	private ResponseEntity<?> createGroup(@PathVariable int userId, @RequestParam String name) {
		try {
			Group group = groupService.createGroup(userId, name);
			return ResponseEntity.ok(group);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create group: " + e.getMessage());
		}
	}

	@PostMapping("/members")
	private ResponseEntity<?> addMembersToGroup(@RequestBody GroupDto groupDto){
		try {
			Group group = groupService.addMembers(groupDto.getGroupId(),groupDto.getUserIdList());
			return ResponseEntity.ok(group);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
