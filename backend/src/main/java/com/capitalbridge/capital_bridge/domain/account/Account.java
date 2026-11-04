package com.capitalbridge.capital_bridge.domain.account;

import java.math.BigDecimal;
import java.util.UUID;
import java.time.LocalDateTime;

public class Account {

    private final UUID id;
    private final String ownerName;
    private BigDecimal balance;
    private AccountStatus status;
    private final LocalDateTime createdAt;

    public Account(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Nome do titular não pode ser nulo ou vazio.");
        }

        this.id = UUID.randomUUID();
        this.ownerName = ownerName.strip();
        this.balance = BigDecimal.ZERO;
        this.status = AccountStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
