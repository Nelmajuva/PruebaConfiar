package co.com.confiar.application.services;

import co.com.confiar.domain.model.Account;
import co.com.confiar.domain.port.in.account.ICreateAccountUseCase;
import co.com.confiar.domain.port.in.account.IRetrieveAccountUseCase;

import java.util.List;
import java.util.Optional;

public class AccountService implements ICreateAccountUseCase, IRetrieveAccountUseCase {
    private final ICreateAccountUseCase createAccountUseCase;
    private final IRetrieveAccountUseCase retrieveAccountUseCase;

    public AccountService(ICreateAccountUseCase createAccountUseCase, IRetrieveAccountUseCase retrieveAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.retrieveAccountUseCase = retrieveAccountUseCase;
    }

    @Override
    public Optional<Account> createAccount(Account account) {
        return this.createAccountUseCase.createAccount(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return this.retrieveAccountUseCase.getAllAccounts();
    }
}
