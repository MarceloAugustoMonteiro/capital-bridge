package com.capitalbridge.capital_bridge.domain.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void shouldRejectInvalidOwnerName(String ownerName) {
        assertThrows(IllegalArgumentException.class, () -> new Account(ownerName));
    }

    @Test
    void shouldTrimOwnerName() {
        Account account = new Account("  John Doe  ");

        assertEquals("John Doe", account.getOwnerName());
    }

    @Test
    void shouldCreateAccount() {
        Account account = new Account("John Doe");

        assertNotNull(account.getId());
        assertEquals("John Doe", account.getOwnerName());
        assertEquals(BigDecimal.ZERO, account.getBalance());
        assertEquals(AccountStatus.ACTIVE, account.getStatus());
        assertNotNull(account.getCreatedAt());
    }
}
