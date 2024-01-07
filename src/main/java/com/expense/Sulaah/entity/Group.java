package com.expense.Sulaah.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_groups")
public class Group {
	@Id
	private int id;
	private String name;

}
