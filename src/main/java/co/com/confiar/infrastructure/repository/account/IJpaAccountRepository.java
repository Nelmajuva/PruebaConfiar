package co.com.confiar.infrastructure.repository.account;

import co.com.confiar.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IJpaAccountRepository extends JpaRepository<AccountEntity, UUID> {
    boolean existsByAccountNumber(int accountNumber);
}
