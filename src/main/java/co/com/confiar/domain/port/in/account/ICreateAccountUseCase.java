package co.com.confiar.domain.port.in.account;

import co.com.confiar.domain.model.Account;

import java.util.Optional;

public interface ICreateAccountUseCase {
    Optional<Account> createAccount(Account account);
}
