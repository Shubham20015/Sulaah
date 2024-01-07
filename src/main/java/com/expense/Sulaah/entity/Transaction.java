package com.expense.Sulaah.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
	@Id
	private int id;
	private double amount;
	private LocalDateTime timestamp;

	@ManyToOne
	private User payer;

	@ManyToOne
	private Group groupId;

	@OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
	private List<ExpenseShareRecord> shareRecord;
}
