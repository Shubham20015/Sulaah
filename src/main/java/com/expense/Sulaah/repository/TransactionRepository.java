package com.expense.Sulaah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expense.Sulaah.entity.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    List<Transaction> findByGroupId(int groupId);
    boolean existsByGroupId(int groupId);
}
