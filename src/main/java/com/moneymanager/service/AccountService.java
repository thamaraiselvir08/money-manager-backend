package com.moneymanager.service;

import com.moneymanager.entity.Account;
import com.moneymanager.entity.Transfer;
import com.moneymanager.repository.AccountRepository;
import com.moneymanager.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepo;
    private final TransferRepository transferRepo;
    public void transfer(String fromId, String toId, double amount) {
        Account from = accountRepo.findById(fromId).orElseThrow();
        Account to = accountRepo.findById(toId).orElseThrow();
        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        accountRepo.save(from);
        accountRepo.save(to);
        transferRepo.save(new Transfer(null, fromId, toId, amount, LocalDateTime.now()));
    }
}