package com.example.bankingportal.repository;

import com.example.bankingportal.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByFromAccountAccountNumberOrToAccountAccountNumber(String from, String to);
}