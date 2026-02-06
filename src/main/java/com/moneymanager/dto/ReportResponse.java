package com.moneymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportResponse {
   private TransactionType type;
   private double totalAmount;
}