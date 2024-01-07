package com.expense.Sulaah.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "expense_share_records")
public class ExpenseShareRecord {
	@Id
	private int id;
	private int share;

	@ManyToOne
	private Transaction transaction;

	@ManyToOne
	private User user;
}
