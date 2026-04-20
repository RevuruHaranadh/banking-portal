package com.example.bankingportal.service.impl;

import com.example.bankingportal.dto.TransferRequest;
import com.example.bankingportal.entity.Account;
import com.example.bankingportal.entity.Transaction;
import com.example.bankingportal.entity.TransactionType;
import com.example.bankingportal.exception.InsufficientBalanceException;
import com.example.bankingportal.exception.ResourceNotFoundException;
import com.example.bankingportal.repository.AccountRepository;
import com.example.bankingportal.repository.TransactionRepository;
import com.example.bankingportal.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public String transfer(TransferRequest request) {
        Account fromAccount = accountRepository.findByAccountNumber(request.getFromAccountNumber())
                .orElseThrow(() -> new ResourceNotFoundException("From account not found"));

        Account toAccount = accountRepository.findByAccountNumber(request.getToAccountNumber())
                .orElseThrow(() -> new ResourceNotFoundException("To account not found"));

        if (fromAccount.getBalance().compareTo(request.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(request.getAmount()));
        toAccount.setBalance(toAccount.getBalance().add(request.getAmount()));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = Transaction.builder()
                .fromAccount(fromAccount)
                .toAccount(toAccount)
                .amount(request.getAmount())
                .type(TransactionType.TRANSFER)
                .transactionDate(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);

        return "Transfer successful";
    }
}