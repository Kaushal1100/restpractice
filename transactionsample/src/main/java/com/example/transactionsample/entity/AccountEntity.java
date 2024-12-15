package com.example.transactionsample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Getter
//@Setter
@Data

public class AccountEntity {
	
	@Id
	private Long id;
	private String accountHolder;
	private double balance;

}
