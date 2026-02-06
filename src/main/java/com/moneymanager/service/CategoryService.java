package com.moneymanager.service;

import com.moneymanager.entity.Category;
import com.moneymanager.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
   private final CategoryRepository repository;

    @Autowired
    MongoDatabaseFactory factory;
    @PostConstruct
    public void checkDb() {
        System.out.println("CONNECTED DB = " + factory.getMongoDatabase().getName());
    }

   public Category create(Category category) {
       return repository.save(category);
   }
    public List<Category> getAll() {
        System.out.println("DB COUNT = " + repository.count());
        List<Category> list = repository.findAll();
        System.out.println("CATEGORIES FROM DB = " + list);
        return list;
    }
}