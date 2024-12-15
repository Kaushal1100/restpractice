package com.example.transactionsample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactionsample.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
