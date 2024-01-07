package com.expense.Sulaah.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	private int id;
	private double amount;
	// private User payer;
	// private Group groupId;
	private LocalDateTime timestamp;
}
