package co.com.confiar.application.usecases.account.historic;

import co.com.confiar.domain.model.AccountHistoric;
import co.com.confiar.domain.port.in.account.historic.IRetrieveAccountHistoricUseCase;
import co.com.confiar.domain.port.out.IAccountHistoricRepositoryPort;

import java.util.List;

public class RetrieveAccountHistoricUseCase implements IRetrieveAccountHistoricUseCase {
    private final IAccountHistoricRepositoryPort accountHistoricRepositoryPort;

    public RetrieveAccountHistoricUseCase(IAccountHistoricRepositoryPort accountHistoricRepositoryPort) {
        this.accountHistoricRepositoryPort = accountHistoricRepositoryPort;
    }

    @Override
    public List<AccountHistoric> getAllAccountsHistoric() {
        return  this.accountHistoricRepositoryPort.findAll();
    }
}
