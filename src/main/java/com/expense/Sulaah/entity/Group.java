package com.expense.Sulaah.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_groups")
public class Group {
	@Id
	private int id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> usersInGroup;

}
