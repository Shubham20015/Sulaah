package com.expense.Sulaah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.Sulaah.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
