package com.expense.Sulaah.entity.activity;

import java.io.Serializable;

import com.expense.Sulaah.entity.Transaction;
import com.expense.Sulaah.entity.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ActivityPK implements Serializable{
	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
