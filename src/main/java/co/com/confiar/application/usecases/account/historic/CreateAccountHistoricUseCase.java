package co.com.confiar.application.usecases.account.historic;

import co.com.confiar.domain.model.AccountHistoric;
import co.com.confiar.domain.port.in.account.historic.ICreateAccountHistoricUseCase;
import co.com.confiar.domain.port.out.IAccountHistoricRepositoryPort;

import java.util.Optional;

public class CreateAccountHistoricUseCase implements ICreateAccountHistoricUseCase {

    private final IAccountHistoricRepositoryPort accountHistoricRepositoryPort;

    public CreateAccountHistoricUseCase(IAccountHistoricRepositoryPort accountHistoricRepositoryPort) {
        this.accountHistoricRepositoryPort = accountHistoricRepositoryPort;
    }

    @Override
    public Optional<AccountHistoric> createAccountHistoric(AccountHistoric accountHistoric) {
        return accountHistoricRepositoryPort.save(accountHistoric);
    }

}
