package co.com.confiar.infrastructure.entity;

import co.com.confiar.domain.model.AccountHistoric;
import co.com.confiar.domain.model.Client;
import co.com.confiar.infrastructure.enums.TypeHistoric;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "accounts_historic")
@Entity
public class AccountHistoricEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID accountId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private TypeHistoric typeHistoric;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public AccountHistoricEntity() {}

    public AccountHistoricEntity(UUID id, UUID accountId, double amount, TypeHistoric typeHistoric, LocalDateTime createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.typeHistoric = typeHistoric;
        this.createdAt = createdAt;
    }

    public static AccountHistoricEntity fromDomainInModel(AccountHistoric accountHistoric) {
        return new AccountHistoricEntity(accountHistoric.getId(), accountHistoric.getAccountId(), accountHistoric.getAmount(), accountHistoric.getTypeHistoric(), accountHistoric.getCreatedAt());
    }

    public AccountHistoric toDomainInModel() {
        return new AccountHistoric(this.id, this.accountId, this.amount, this.typeHistoric, this.createdAt);
    }
}
