package com.expense.Sulaah.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "expense_share_records")
public class ExpenseShareRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_share_record_id")
	private int id;
	@Column(name = "share")
	private int share;
	@ManyToOne
	@JoinColumn(name = "transaction_id", nullable = false)
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
