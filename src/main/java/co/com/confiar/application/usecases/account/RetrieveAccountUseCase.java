package co.com.confiar.application.usecases.account;

import co.com.confiar.domain.model.Account;
import co.com.confiar.domain.port.in.account.IRetrieveAccountUseCase;
import co.com.confiar.domain.port.out.IAccountRepositoryPort;

import java.util.List;

public class RetrieveAccountUseCase implements IRetrieveAccountUseCase {
    private final IAccountRepositoryPort accountRepositoryPort;

    public RetrieveAccountUseCase(IAccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public List<Account> getAllAccounts() {
        return  this.accountRepositoryPort.findAll();
    }
}
