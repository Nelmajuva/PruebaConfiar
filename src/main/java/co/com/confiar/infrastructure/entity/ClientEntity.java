package co.com.confiar.infrastructure.entity;
import co.com.confiar.domain.model.Client;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "clients")
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, length = 16)
    private String identification;

    @Column(length = 120)
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public ClientEntity() {}

    public ClientEntity(UUID id, String identification, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ClientEntity fromDomainInModel(Client client) {
        return new ClientEntity(client.getId(), client.getIdentification(), client.getName(), client.getCreatedAt(), client.getUpdatedAt());
    }

    public Client toDomainInModel() {
        return new Client(this.id, this.identification, this.name, this.createdAt, this.updatedAt);
    }
}
