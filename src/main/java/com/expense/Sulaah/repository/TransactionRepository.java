package com.expense.Sulaah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.Sulaah.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
