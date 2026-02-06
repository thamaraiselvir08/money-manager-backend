package com.moneymanager.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transfers")
public class Transfer {
   @Id
   private String id;
   private String fromAccountId;
   private String toAccountId;
   private double amount;
   private LocalDateTime transferDate;
}