package com.moneymanager.controller;

import com.moneymanager.dto.CategoryReportResponse;
import com.moneymanager.dto.Division;
import com.moneymanager.dto.ReportResponse;
import com.moneymanager.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
   private final ReportService reportService;
   @GetMapping("/weekly")
   public List<ReportResponse> weekly() {
       return reportService.weeklyReport();
   }
   @GetMapping("/monthly")
   public List<ReportResponse> monthly(
           @RequestParam int year,
           @RequestParam int month) {
       return reportService.monthlyReport(year, month);
   }
   @GetMapping("/yearly")
   public List<ReportResponse> yearly(
           @RequestParam int year) {
       return reportService.yearlyReport(year);
   }
   @GetMapping("/category")
   public List<CategoryReportResponse> category(
           @RequestParam String start,
           @RequestParam String end) {
       return reportService.categoryReport(
               LocalDateTime.parse(start),
               LocalDateTime.parse(end));
   }
    @GetMapping("/division")
    public List<ReportResponse> divisionReport(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam Division division) {
        return reportService.divisionReport(
                LocalDateTime.parse(start),
                LocalDateTime.parse(end),
                division);
    }
}