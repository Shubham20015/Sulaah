package com.expense.Sulaah.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "expense_share_records")
public class ExpenseShareRecord {
	@Id
	@Column(name = "expense_share_record_id")
	private int id;
	@Column(name = "share")
	private int share;

	@ManyToOne
	private Transaction transaction;

	@ManyToOne
	private User user;
}
