package com.expense.Sulaah.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "group_table")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "total_amount")
	private Double totalAmount;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "groups")
	@JsonIgnore
	private List<User> usersInGroup;

}
