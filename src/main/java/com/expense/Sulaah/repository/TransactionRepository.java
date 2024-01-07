package com.expense.Sulaah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.Sulaah.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public List<Transaction> findAllByGroupId(int groupId);
}
