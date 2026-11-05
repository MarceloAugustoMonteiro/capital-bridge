package com.capitalbridge.capital_bridge.application.account;

import com.capitalbridge.capital_bridge.domain.account.Account;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

   private final Map<UUID, Account> accounts = new ConcurrentHashMap<>();

   public Account createAccount(String ownerName) {
      Account account = new Account(ownerName);

      accounts.put(account.getId(), account);

      return account;
   }

   public Account getAccountById(UUID id) {
      return Optional.ofNullable(accounts.get(id))
            .orElseThrow(() -> new NoSuchElementException(
                  "Account with id " + id + " not found"));
   }
}
