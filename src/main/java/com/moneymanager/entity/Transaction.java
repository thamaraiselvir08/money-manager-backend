package com.moneymanager.entity;

import com.moneymanager.dto.Division;
import com.moneymanager.dto.TransactionType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactions")
public class Transaction {
   @Id
   private String id;
   private TransactionType type;
   private double amount;
   private String category;
   private Division division;
   private String description;
   private String accountId;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
}