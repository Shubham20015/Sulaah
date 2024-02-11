package com.expense.Sulaah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.entity.Dto.TransactionDto;

@Service
public class SampleData {
	@Autowired
	private UserService userv;

	@Autowired
	private GroupService gserv;

	@Autowired
	private TransactionService tserv;

	public String add_test_data() {
		if (userv.getUserByEmail("tony023@test.com") != null) {
			return "Data already present";
		}

		User user1 = new User();
		user1.setUsername("Tony");
		user1.setEmail("tony023@test.com");
		user1 = userv.createUser(user1);

		User user2 = new User();
		user2.setUsername("Garry");
		user2.setEmail("garry009@test.com");
		user2 = userv.createUser(user2);

		Group group = new Group();
		group.setName("Trip");
		group = gserv.createGroup(user1.getId(), group);
		// gserv.addUserToGroup(group, user2);
		// System.out.println(group.getUsersInGroup());
		userv.addUserToGroup(user1, group);
		userv.addUserToGroup(user2, group);

		User user3 = new User();
		user3.setUsername("Julie");
		user3.setEmail("julie001@test.com");
		user3 = userv.createUser(user3);

		// add transaction
		TransactionDto trans = new TransactionDto(
				100.0,
				user1.getId(),
				group.getId(),
				List.of(user1.getId(), user2.getId()));
		tserv.addTransaction(trans);
		return "Data added";
	}
}
