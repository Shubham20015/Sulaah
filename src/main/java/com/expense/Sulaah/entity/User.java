package com.expense.Sulaah.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "debit_amount", columnDefinition = "DOUBLE DEFAULT 0.0")
	private double debitAmount;
	@Column(name = "credit_amount", columnDefinition = "DOUBLE DEFAULT 0.0")
	private double creditAmount;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_group_map", joinColumns = @JoinColumn(name = "user_id"),
					inverseJoinColumns = @JoinColumn(name = "group_id"))
	private List<Group> groups;

}
