package com.capitalbridge.capital_bridge.application.account;

import com.capitalbridge.capital_bridge.domain.account.Account;
import com.capitalbridge.capital_bridge.domain.account.AccountStatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setup() {
        accountService = new AccountService();
    }

    @Test
    void shouldCreateAccount() {
        Account account = accountService.createAccount("John Doe");

        assertNotNull(account.getId());
        assertEquals("John Doe", account.getOwnerName());
        assertEquals(BigDecimal.ZERO, account.getBalance());
        assertEquals(AccountStatus.ACTIVE, account.getStatus());
    }

    @Test
    void shouldFindAccountById() {
        Account createdAccount = accountService.createAccount("John Doe");

        Account foundAccount = accountService.getAccountById(createdAccount.getId());

        assertEquals(createdAccount.getId(), foundAccount.getId());
        assertEquals(createdAccount.getOwnerName(), foundAccount.getOwnerName());
    }

    @Test
    void shouldThrowWhenAccountNotFound() {
        UUID nonexistentId = UUID.randomUUID();

        assertThrows(
            NoSuchElementException.class,
            () -> accountService.getAccountById(nonexistentId)
        );
    }
}