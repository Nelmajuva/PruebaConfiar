package co.com.confiar.application.services;

import co.com.confiar.domain.model.AccountHistoric;
import co.com.confiar.domain.port.in.account.historic.ICreateAccountHistoricUseCase;
import co.com.confiar.domain.port.in.account.historic.IRetrieveAccountHistoricUseCase;

import java.util.List;
import java.util.Optional;

public class AccountHistoricService implements ICreateAccountHistoricUseCase, IRetrieveAccountHistoricUseCase {
    private final ICreateAccountHistoricUseCase createAccountHistoricUseCase;
    private final IRetrieveAccountHistoricUseCase retrieveAccountHistoricUseCase;

    public AccountHistoricService(ICreateAccountHistoricUseCase createAccountHistoricUseCase, IRetrieveAccountHistoricUseCase retrieveAccountHistoricUseCase) {
        this.createAccountHistoricUseCase = createAccountHistoricUseCase;
        this.retrieveAccountHistoricUseCase = retrieveAccountHistoricUseCase;
    }

    @Override
    public Optional<AccountHistoric> createAccountHistoric(AccountHistoric accountHistoric) {
        return this.createAccountHistoricUseCase.createAccountHistoric(accountHistoric);
    }

    @Override
    public List<AccountHistoric> getAllAccountsHistoric() {
        return this.retrieveAccountHistoricUseCase.getAllAccountsHistoric();
    }
}
