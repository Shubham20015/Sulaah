package com.expense.Sulaah.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Double amountPaid;

    private int userId;

    private int groupId;

    private List<Integer> userIdList;
}
