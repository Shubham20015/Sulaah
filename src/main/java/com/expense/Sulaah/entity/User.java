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
@Table(name = "all_users")
public class User {
	@Id
	private int id;
	private String username;
	private String email;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "usersInGroup")
	private List<Group> groups;

}
