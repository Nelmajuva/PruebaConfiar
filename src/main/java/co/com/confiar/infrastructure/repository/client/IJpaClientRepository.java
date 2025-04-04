package co.com.confiar.infrastructure.repository.client;

import co.com.confiar.infrastructure.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IJpaClientRepository extends JpaRepository<ClientEntity, UUID> {
    boolean existsByIdentification(String identification);
}
