package com.moneymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryReportResponse {
   private String category;
   private double totalAmount;
}