package co.com.confiar.domain.port.in.account;

import co.com.confiar.domain.model.Account;

import java.util.List;

public interface IRetrieveAccountUseCase {
    List<Account> getAllAccounts();
}
