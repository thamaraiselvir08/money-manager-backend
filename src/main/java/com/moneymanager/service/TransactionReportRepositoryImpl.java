package com.moneymanager.service;

import com.moneymanager.dto.CategoryReportResponse;
import com.moneymanager.dto.Division;
import com.moneymanager.dto.ReportResponse;
import com.moneymanager.entity.Transaction;
import com.moneymanager.repository.TransactionReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransactionReportRepositoryImpl implements TransactionReportRepository {
   private final MongoTemplate mongoTemplate;
   @Override
   public List<ReportResponse> getSummary(LocalDateTime start, LocalDateTime end) {
       MatchOperation match = Aggregation.match(
               Criteria.where("createdAt").gte(start).lte(end)
       );
       GroupOperation group = Aggregation.group("type")
               .sum("amount").as("totalAmount");
       ProjectionOperation project = Aggregation.project()
               .and("_id").as("type")
               .and("totalAmount").as("totalAmount");
       Aggregation aggregation = Aggregation.newAggregation(match, group, project);
       return mongoTemplate.aggregate(
               aggregation,
               Transaction.class,
               ReportResponse.class
       ).getMappedResults();
   }
   @Override
   public List<CategoryReportResponse> getCategorySummary(LocalDateTime start, LocalDateTime end) {
       MatchOperation match = Aggregation.match(
               Criteria.where("createdAt").gte(start).lte(end)
       );
       GroupOperation group = Aggregation.group("category")
               .sum("amount").as("totalAmount");
       ProjectionOperation project = Aggregation.project()
               .and("_id").as("category")
               .and("totalAmount").as("totalAmount");
       Aggregation aggregation = Aggregation.newAggregation(match, group, project);
       return mongoTemplate.aggregate(
               aggregation,
               Transaction.class,
               CategoryReportResponse.class
       ).getMappedResults();
   }
    @Override
    public List<ReportResponse> getSummaryByDivision(
            LocalDateTime start,
            LocalDateTime end,
            Division division) {
        MatchOperation match = Aggregation.match(
                Criteria.where("createdAt").gte(start).lte(end)
                        .and("division").is(division)
        );
        GroupOperation group = Aggregation.group("type")
                .sum("amount").as("totalAmount");
        ProjectionOperation project = Aggregation.project()
                .and("_id").as("type")
                .and("totalAmount").as("totalAmount");
        Aggregation aggregation = Aggregation.newAggregation(match, group, project);
        return mongoTemplate.aggregate(
                aggregation,
                Transaction.class,
                ReportResponse.class
        ).getMappedResults();
    }
}