package com.moneymanager.repository;

import com.moneymanager.dto.Division;
import com.moneymanager.dto.TransactionType;
import com.moneymanager.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
   List<Transaction> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
   List<Transaction> findByType(TransactionType type);
   List<Transaction> findAllByOrderByCreatedAtDesc();
   List<Transaction> findByCategoryAndDivision(String category, Division division);
}