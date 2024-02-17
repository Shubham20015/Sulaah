package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Dto.TransactionDto;
import com.expense.Sulaah.entity.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    Transaction addTransaction(TransactionDto transaction);
    List<Transaction> getAllTransactionsByGroupId(int groupId);
    Transaction updateTransaction(UUID id, Transaction updatedTransaction);
}
