package co.com.confiar.domain.port.out;

import co.com.confiar.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountRepositoryPort {
    Optional<Account> save(Account account);

    List<Account> findAll();
}
