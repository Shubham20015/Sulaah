package com.expense.Sulaah.controller;

import com.expense.Sulaah.entity.Dto.TransactionDto;
import com.expense.Sulaah.entity.Transaction;
import com.expense.Sulaah.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{id}")
    private List<Transaction> getTransactionsInGroup(@PathVariable int id){
        return transactionService.getAllTransactionsByGroupId(id);
    }

    @PostMapping()
    private Transaction addTransaction(@RequestBody TransactionDto transaction){
        return transactionService.addTransaction(transaction);
    }
}
