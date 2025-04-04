package co.com.confiar.domain.port.in.account.historic;

import co.com.confiar.domain.model.AccountHistoric;

import java.util.List;

public interface IRetrieveAccountHistoricUseCase {
    List<AccountHistoric> getAllAccountsHistoric();
}
