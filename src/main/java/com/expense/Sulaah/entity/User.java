package com.expense.Sulaah.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "debit_amount")
	private double debitAmount;
	@Column(name = "credit_amount")
	private double creditAmount;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "usersInGroup")
	private List<Group> groups;

}
