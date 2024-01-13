package com.expense.Sulaah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.service.GroupService;

@RestController
@RequestMapping("/apis/groups")
public class GroupController {
	@Autowired
	private GroupService groupService;

	@GetMapping("/{id}")
	private Group getGroup(@PathVariable int id) {
		return groupService.getGroupById(id);
	}

	@PostMapping("/u-{userId}")
	public Group createGroup(@PathVariable int userId, @RequestBody Group group) {
		return groupService.createGroup(userId, group);
	}

}
