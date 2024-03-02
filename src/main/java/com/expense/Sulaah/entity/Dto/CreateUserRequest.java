package com.expense.Sulaah.entity.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
	@NotBlank
	private String username;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String hashedPassword;
}
