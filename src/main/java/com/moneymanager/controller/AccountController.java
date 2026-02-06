package com.moneymanager.controller;

import com.moneymanager.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
   private final AccountService service;
   @PostMapping("/transfer")
   public void transfer(
           @RequestParam String from,
           @RequestParam String to,
           @RequestParam double amount) {
      service.transfer(from, to, amount);
   }
}