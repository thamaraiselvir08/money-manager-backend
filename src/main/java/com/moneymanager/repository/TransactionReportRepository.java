package com.moneymanager.repository;

import com.moneymanager.dto.CategoryReportResponse;
import com.moneymanager.dto.Division;
import com.moneymanager.dto.ReportResponse;

import java.time.LocalDateTime;
import java.util.List;
public interface TransactionReportRepository {
   List<ReportResponse> getSummary(LocalDateTime start, LocalDateTime end);
   List<CategoryReportResponse> getCategorySummary(LocalDateTime start, LocalDateTime end);
   List<ReportResponse> getSummaryByDivision(
           LocalDateTime start,
           LocalDateTime end,
           Division division);
}