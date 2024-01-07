package com.expense.Sulaah.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_groups")
public class Group {
	@Id
	@Column(name = "group_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "total_amount")
	private Double totalAmount;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> usersInGroup;

}
