package co.com.confiar.domain.port.in.account.historic;

import co.com.confiar.domain.model.AccountHistoric;

import java.util.Optional;

public interface ICreateAccountHistoricUseCase {
    Optional<AccountHistoric> createAccountHistoric(AccountHistoric accountHistoric);
}
