package com.expense.Sulaah.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "all_users")
public class User {
	@Id
	private int id;
	private String username;
	private String email;

}
