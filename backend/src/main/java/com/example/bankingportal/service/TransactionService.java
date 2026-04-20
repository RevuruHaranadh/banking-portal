package com.example.bankingportal.service;

import com.example.bankingportal.dto.TransferRequest;

public interface TransactionService {
    String transfer(TransferRequest request);
}