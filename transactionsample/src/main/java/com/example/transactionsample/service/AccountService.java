package com.example.transactionsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactionsample.entity.AccountEntity;
import com.example.transactionsample.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
		@Transactional
		public void transferMoney(Long fromAccountId, Long toAccountId, double amount) {
			//
			 AccountEntity fromAccount = accountRepository.findById(fromAccountId)
		                .orElseThrow(() -> new RuntimeException("Sender account not found!"));
		     AccountEntity toAccount = accountRepository.findById(toAccountId)
		                .orElseThrow(() -> new RuntimeException("Receiver account not found!"));
	
			
		
			if (fromAccount.getBalance()<=amount) {
				System.out.println("Not Enough Balance");
			}
			
			fromAccount.setBalance(fromAccount.getBalance()-amount);
			toAccount.setBalance(toAccount.getBalance()+amount);
			
			accountRepository.save(fromAccount);
			accountRepository.save(toAccount);
		}
		

}
