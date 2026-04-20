package com.example.bankingportal.controller;

import com.example.bankingportal.dto.TransferRequest;
import com.example.bankingportal.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest request) {
        return transactionService.transfer(request);
    }
}