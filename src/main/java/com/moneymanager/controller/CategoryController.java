package com.moneymanager.controller;

import com.moneymanager.entity.Category;
import com.moneymanager.repository.CategoryRepository;
import com.moneymanager.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
   private final CategoryService service;
   private final CategoryRepository categoryRepository;
   @PostMapping
   public Category create(@RequestBody Category category) {
       return service.create(category);
   }
    @Operation(summary = "Get all categories", description = "Returns a list of all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
   @GetMapping
   public List<Category> getAll() {
       return service.getAll();
   }
    @PostMapping("/debug-insert")
    public String debugInsert() {
        categoryRepository.save(new Category("debug1", "DebugCategory"));
        return "Inserted";
    }
}