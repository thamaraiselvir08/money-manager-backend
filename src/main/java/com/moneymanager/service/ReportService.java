package com.moneymanager.service;

import com.moneymanager.dto.CategoryReportResponse;
import com.moneymanager.dto.Division;
import com.moneymanager.dto.ReportResponse;
import com.moneymanager.repository.TransactionReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
   private final TransactionReportRepository reportRepository;
   public List<ReportResponse> weeklyReport() {
       LocalDateTime start = LocalDate.now().with(java.time.DayOfWeek.MONDAY).atStartOfDay();
       LocalDateTime end = start.plusDays(6).withHour(23).withMinute(59);
       return reportRepository.getSummary(start, end);
   }
   public List<ReportResponse> monthlyReport(int year, int month) {
       LocalDateTime start = LocalDate.of(year, month, 1).atStartOfDay();
       LocalDateTime end = start.with(TemporalAdjusters.lastDayOfMonth())
               .withHour(23).withMinute(59);
       return reportRepository.getSummary(start, end);
   }
   public List<ReportResponse> yearlyReport(int year) {
       LocalDateTime start = LocalDate.of(year, 1, 1).atStartOfDay();
       LocalDateTime end = LocalDate.of(year, 12, 31).atTime(23, 59);
       return reportRepository.getSummary(start, end);
   }
   public List<CategoryReportResponse> categoryReport(
           LocalDateTime start,
           LocalDateTime end) {
       return reportRepository.getCategorySummary(start, end);
   }
    public List<ReportResponse> divisionReport(
            LocalDateTime start,
            LocalDateTime end,
            Division division) {
        return reportRepository.getSummaryByDivision(start, end, division);
    }
}