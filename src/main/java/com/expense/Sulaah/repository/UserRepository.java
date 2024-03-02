package com.expense.Sulaah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.Sulaah.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmailIgnoreCase(String email);

}
