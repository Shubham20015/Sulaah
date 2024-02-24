package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Dto.TransactionDto;
import com.expense.Sulaah.entity.ExpenseShareRecord;
import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.Transaction;
import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.repository.ExpenseShareRepository;
import com.expense.Sulaah.repository.GroupRepository;
import com.expense.Sulaah.repository.TransactionRepository;
import com.expense.Sulaah.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private ExpenseShareRepository expenseShareRepository;

	@Override
	public Transaction addTransaction(TransactionDto transactionDto) {

		User user = userRepository.findById(transactionDto.getPayerId()).get();
		Group group = groupRepository.findById(transactionDto.getGroupId()).get();

		Transaction transaction = Transaction
				.builder()
				.id(UUID.randomUUID())
				.description(transactionDto.getDescription())
				.amountPaid(transactionDto.getAmountPaid())
				.payer(user)
				.group(group)
				.build();

		transaction = transactionRepository.save(transaction);

		List<ExpenseShareRecord> shareRecord = new ArrayList<>();
		for (int eachUser : transactionDto.getUserIdWithShare().keySet()) {
			ExpenseShareRecord record = ExpenseShareRecord
					.builder()
					.share(transactionDto.getUserIdWithShare().get(eachUser))
					.transaction(transaction)
					.user(userRepository.findById(eachUser).get())		// TODO: remove this multiple time fetching
					.build();
			record = expenseShareRepository.save(record);
			shareRecord.add(record);
		}
		transaction.setShareRecord(shareRecord);
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getAllTransactionsByGroupId(int groupId) throws RuntimeException {

		if (!transactionRepository.existsByGroupId(groupId)) {
			throw new RuntimeException("No transaction found with this GroupID: " + groupId);
		}

		return transactionRepository.findByGroupId(groupId);
	}

	@Override
	public Transaction updateTransaction(UUID id, Transaction updatedTransaction) throws IllegalArgumentException {
		Transaction existingTransaction = transactionRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Transaction not found with id: " + id));

		BeanUtils.copyProperties(updatedTransaction, existingTransaction, "id", "createdAt");

		return transactionRepository.save(existingTransaction);
	}
}
