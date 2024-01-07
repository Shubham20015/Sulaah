package com.expense.Sulaah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.Sulaah.entity.ExpenseShareRecord;

public interface ExpenseShareRepository extends JpaRepository<ExpenseShareRecord, Integer> {

}
