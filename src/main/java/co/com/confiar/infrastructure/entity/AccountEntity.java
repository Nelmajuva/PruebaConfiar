package co.com.confiar.infrastructure.entity;

import co.com.confiar.domain.model.Account;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "accounts")
@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID clientId;

    @Column(nullable = false)
    private int accountNumber;

    @Column(nullable = false)
    private double availableBalance;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public AccountEntity() {}

    public AccountEntity(UUID id, UUID clientId, int accountNumber, double availableBalance, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.clientId = clientId;

        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static AccountEntity fromDomainInModel(Account account) {
        return new AccountEntity(account.getId(), account.getClientId(), account.getAccountNumber(), account.getAvailableBalance(), account.getCreatedAt(), account.getUpdatedAt());
    }

    public Account toDomainInModel() {
        return new Account(this.id, this.clientId, this.accountNumber, this.availableBalance, this.createdAt, this.updatedAt);
    }

    public double getAvailableBalance() {
        return this.availableBalance;
    }

    public void setAvailableBalance(double newAvailableBalance) {
        this.availableBalance = newAvailableBalance;
    }
}
