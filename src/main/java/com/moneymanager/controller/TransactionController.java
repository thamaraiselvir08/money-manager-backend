package com.moneymanager.controller;

import com.moneymanager.dto.Division;
import com.moneymanager.entity.Transaction;
import com.moneymanager.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;
    @PostMapping
    public Transaction add(@RequestBody Transaction transaction) {
        return service.add(transaction);
    }
    @PutMapping("/{id}")
    public Transaction update(@PathVariable String id, @RequestBody Transaction transaction) {
        return service.update(id, transaction);
    }
    @GetMapping("/between")
    public List<Transaction> betweenDates(
            @RequestParam String start,
            @RequestParam String end) {
        return service.getBetweenDates(
                LocalDateTime.parse(start),
                LocalDateTime.parse(end));
    }
    @GetMapping
    public List<Transaction> history() {
        return service.getAllHistory();
    }
    @GetMapping("/filter")
    public List<Transaction> filter(
            @RequestParam String category,
            @RequestParam Division division) {
        return service.filter(category, division);
    }
}