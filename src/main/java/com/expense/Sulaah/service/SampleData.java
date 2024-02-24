package com.expense.Sulaah.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.entity.Dto.TransactionDto;

@Service
public class SampleData {
	@Autowired
	private UserService userService;

	@Autowired
	private GroupService groupService;

	@Autowired
	private TransactionService transactionService;

	public String addTestData() {
//		try {
//			if (userService.getUserByEmail("tony023@test.com") != null) {
//				return "Data already present";
//			}
//		} catch (Exception e){
//			e.printStackTrace();
//		}

		User user1 = new User();
		user1.setUsername("Tony");
		user1.setEmail("tony023@test.com");
		user1 = userService.createUser(user1);

		User user2 = new User();
		user2.setUsername("Garry");
		user2.setEmail("garry009@test.com");
		user2 = userService.createUser(user2);

		Group group = groupService.createGroup(user1.getId(), "Trip");
		groupService.addMembers(group.getId(), List.of(user1.getId(),user2.getId()));

		User user3 = new User();
		user3.setUsername("Julie");
		user3.setEmail("julie001@test.com");
		user3 = userService.createUser(user3);

		// add transaction
		TransactionDto trans = new TransactionDto(
				100.0,
				"Test Data",
				user1.getId(),
				group.getId(),
				Map.of(user1.getId(), 1, user2.getId(), 1));
		transactionService.addTransaction(trans);
		return "Data added";
	}
}
