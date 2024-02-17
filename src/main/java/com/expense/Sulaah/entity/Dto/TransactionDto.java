package com.expense.Sulaah.entity.Dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Double amountPaid;

	private String description;

    private int userId;

    private int groupId;

	private Map<Integer, Integer> userIdWithShare;
}
