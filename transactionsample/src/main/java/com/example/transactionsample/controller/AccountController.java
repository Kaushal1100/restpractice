package com.example.transactionsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactionsample.service.AccountService;

@RestController
@RequestMapping("/transactions")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
		@PostMapping("/transfer")
		public String transferMoney(@RequestParam Long fromAccount, 
									@RequestParam Long toAccount,
									@RequestParam double amount) {
			
			accountService.transferMoney(fromAccount, toAccount, amount);
			return "TransferComplete";
			
			
		}

}
