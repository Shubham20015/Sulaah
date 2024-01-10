package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Transaction;
import com.expense.Sulaah.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsByGroupId(int groupId) {
        if(!transactionRepository.findById(groupId).isPresent()) return new ArrayList<>();
        return transactionRepository.findByGroupId(groupId);
    }
}
