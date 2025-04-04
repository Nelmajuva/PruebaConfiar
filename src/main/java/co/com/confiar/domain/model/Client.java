package co.com.confiar.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Client {
    private UUID id;

    private String identification;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Client () {}

    public Client (String identification, String name) {
        this.id = UUID.randomUUID();

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        this.identification = identification;
        this.name = name;
    }

    public Client(UUID id, String identification, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

        this.identification = identification;
        this.name = name;
    }

    public UUID getId() {
        return this.id;
    }

    public String getIdentification() {
        return this.identification;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
}
