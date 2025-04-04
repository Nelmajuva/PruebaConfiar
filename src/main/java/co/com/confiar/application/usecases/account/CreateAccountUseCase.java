package co.com.confiar.application.usecases.account;

import co.com.confiar.domain.model.Account;
import co.com.confiar.domain.port.in.account.ICreateAccountUseCase;
import co.com.confiar.domain.port.out.IAccountRepositoryPort;

import java.util.Optional;

public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final IAccountRepositoryPort accountRepositoryPort;

    public CreateAccountUseCase(IAccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Optional<Account> createAccount(Account account) {
        return accountRepositoryPort.save(account);
    }

}
