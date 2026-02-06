package com.moneymanager.service;

import com.moneymanager.dto.Division;
import com.moneymanager.dto.TransactionType;
import com.moneymanager.entity.Account;
import com.moneymanager.entity.Transaction;
import com.moneymanager.repository.AccountRepository;
import com.moneymanager.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;
    private final AccountRepository accountRepository;
    public Transaction add(Transaction transaction) {
        Account account = accountRepository.findById(transaction.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (transaction.getType() == TransactionType.INCOME) {
            account.setBalance(account.getBalance() + transaction.getAmount());
        } else {
            if (account.getBalance() < transaction.getAmount()) {
                throw new RuntimeException("Insufficient balance");
            }
            account.setBalance(account.getBalance() - transaction.getAmount());
        }
        accountRepository.save(account);
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setUpdatedAt(LocalDateTime.now());
        return repository.save(transaction);
    }
    public Transaction update(String id, Transaction updated) {
        Transaction existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        long hours = Duration.between(existing.getCreatedAt(), LocalDateTime.now()).toHours();
        if (hours > 12) {
            throw new RuntimeException("Editing not allowed after 12 hours");
        }
        existing.setAmount(updated.getAmount());
        existing.setCategory(updated.getCategory());
        existing.setDivision(updated.getDivision());
        existing.setDescription(updated.getDescription());
        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }
    public List<Transaction> getBetweenDates(LocalDateTime start, LocalDateTime end) {
        return repository.findByCreatedAtBetween(start, end);
    }

    public List<Transaction> getAllHistory() {
        return repository.findAllByOrderByCreatedAtDesc();
    }
    public List<Transaction> filter(String category, Division division) {
        return repository.findByCategoryAndDivision(category, division);
    }
}