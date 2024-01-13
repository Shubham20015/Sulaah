package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Dto.TransactionDto;
import com.expense.Sulaah.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(TransactionDto transaction);
    List<Transaction> getAllTransactionsByGroupId(int groupId);
}
