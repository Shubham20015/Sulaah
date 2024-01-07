package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction addTransaction(Transaction transaction);
    public List<Transaction> getAllTransactionsByGroupId(int groupId);
}
