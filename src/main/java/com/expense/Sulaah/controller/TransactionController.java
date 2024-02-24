package com.expense.Sulaah.controller;

import com.expense.Sulaah.entity.Dto.TransactionDto;
import com.expense.Sulaah.entity.Transaction;
import com.expense.Sulaah.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apis/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/{id}")
	private ResponseEntity<?> getTransactionsInGroup(@PathVariable int id) {
		try {
			List<Transaction> transactionList = transactionService.getAllTransactionsByGroupId(id);
			return ResponseEntity.ok(transactionList);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Get: " + e.getMessage());
		}
	}

	@PostMapping("/")
	private Transaction addTransaction(@RequestBody TransactionDto transactionDto) {
//		groupService.addMembers(transaction.getGroupId(),transaction.getUserIdWithShare().keySet().stream().toList());
		return transactionService.addTransaction(transactionDto);
	}

	@PutMapping("/{id}")
	private ResponseEntity<?> updateTransaction(@PathVariable long id, @RequestBody Transaction updatedTransaction) {
		try {
			UUID uuid = UUID.fromString(String.valueOf(id));
			return ResponseEntity.ok(transactionService.updateTransaction(uuid, updatedTransaction));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}

	}
}
