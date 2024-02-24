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
@Table(name = "group_table")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "total_amount")
	private Double totalAmount;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_group_map", joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	private List<User> usersInGroup;

}
