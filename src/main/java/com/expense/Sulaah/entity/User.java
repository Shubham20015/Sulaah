package com.expense.Sulaah.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
	@NotBlank
	@Length(min = 2,max = 20)
	private String username;
	@Email
	@NotBlank
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "debit_amount", columnDefinition = "DOUBLE DEFAULT 0.0")
	private double debitAmount;
	@Column(name = "credit_amount", columnDefinition = "DOUBLE DEFAULT 0.0")
	private double creditAmount;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "usersInGroup")
	@JsonBackReference
	private List<Group> groups;

}
