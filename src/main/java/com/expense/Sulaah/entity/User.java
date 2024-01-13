package com.expense.Sulaah.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "debit_amount")
	private double debitAmount = 0.0;
	@Column(name = "credit_amount")
	private double creditAmount = 0.0;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "usersInGroup")
	// TODO: Remove following comment by adding knowledge to wiki
	//	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Group> groups;

}
