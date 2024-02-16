package com.expense.Sulaah.entity.activity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "activity")
public class Activity {
	@EmbeddedId
	private ActivityPK id;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "activity_type")
	private ActivityType type;
}
