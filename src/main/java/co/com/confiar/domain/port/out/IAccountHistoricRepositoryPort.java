package co.com.confiar.domain.port.out;

import co.com.confiar.domain.model.AccountHistoric;

import java.util.List;
import java.util.Optional;

public interface IAccountHistoricRepositoryPort {
    Optional<AccountHistoric> save(AccountHistoric accountHistoric);

    List<AccountHistoric> findAll();
}
