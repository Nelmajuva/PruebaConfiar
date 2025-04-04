package co.com.confiar.domain.model;

import co.com.confiar.infrastructure.enums.TypeHistoric;

import java.time.LocalDateTime;
import java.util.UUID;

public class AccountHistoric {
    private UUID id;

    private UUID accountId;

    private double amount;

    private TypeHistoric typeHistoric;

    private LocalDateTime createdAt;

    public AccountHistoric() {}

    public AccountHistoric(UUID accountId, double amount, TypeHistoric typeHistoric) {
        this.id = UUID.randomUUID();
        this.accountId = accountId;

        this.amount = amount;
        this.typeHistoric = typeHistoric;

        this.createdAt = LocalDateTime.now();
    }

    public AccountHistoric(UUID id, UUID accountId, double amount, TypeHistoric typeHistoric, LocalDateTime createdAt) {
        this.id = id;
        this.accountId = accountId;

        this.amount = amount;
        this.typeHistoric = typeHistoric;

        this.createdAt = createdAt;
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getAccountId() {
        return this.accountId;
    }

    public double getAmount() {
        return this.amount;
    }

    public TypeHistoric getTypeHistoric() {
        return this.typeHistoric;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}
