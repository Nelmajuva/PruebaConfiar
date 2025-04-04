package co.com.confiar.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Account {
    private UUID id;

    private UUID clientId;

    private int accountNumber;

    private double availableBalance;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Account() {}

    public Account(UUID clientId, int accountNumber, double availableBalance) {
        this.id = UUID.randomUUID();
        this.clientId = clientId;

        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Account(UUID id, UUID clientId, int accountNumber, double availableBalance, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.clientId = clientId;

        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getClientId() {
        return this.clientId;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getAvailableBalance() {
        return this.availableBalance;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
}
