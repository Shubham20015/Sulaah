package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Dto.TransactionDto;
import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.Transaction;
import com.expense.Sulaah.entity.User;
import com.expense.Sulaah.repository.GroupRepository;
import com.expense.Sulaah.repository.TransactionRepository;
import com.expense.Sulaah.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Transaction addTransaction(TransactionDto transactionDto) {

        User user = userRepository.findById(transactionDto.getUserId()).get();
        Group group = groupRepository.findById(transactionDto.getGroupId()).get();

        Transaction transaction = Transaction
                                    .builder()
                                    .id(UUID.randomUUID())
                                    .amountPaid(transactionDto.getAmountPaid())
                                    .payer(user)
                                    .group(group)
                                    .build();

        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactionsByGroupId(int groupId) {
        if(!transactionRepository.findById(groupId).isPresent()) return new ArrayList<>();
        return transactionRepository.findByGroupId(groupId);
    }
}
