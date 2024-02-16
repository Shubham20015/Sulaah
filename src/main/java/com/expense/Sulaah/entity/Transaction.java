package com.expense.Sulaah.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;
	@Column(name = "amount_paid")
	private double amountPaid;
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User payer;
	@ManyToOne
	@JoinColumn(name = "group_id", nullable = false)
	private Group group;
	@OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
	private List<ExpenseShareRecord> shareRecord;
}
