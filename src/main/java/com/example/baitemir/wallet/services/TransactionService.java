package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.dto.TransactionRequest;
import com.example.baitemir.wallet.enteties.Transaction;

import java.util.List;

public interface TransactionService {
    public String transaction(Long from, Long to, TransactionRequest request);
    public List<Transaction> getTransactions();
}
