package co.com.confiar.infrastructure.repository.account.historic;

import co.com.confiar.infrastructure.entity.AccountHistoricEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IJpaAccountHistoricRepository extends JpaRepository<AccountHistoricEntity, UUID> {
}
