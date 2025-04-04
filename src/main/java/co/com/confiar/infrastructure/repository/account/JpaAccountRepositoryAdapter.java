package co.com.confiar.infrastructure.repository.account;

import co.com.confiar.domain.model.Account;
import co.com.confiar.domain.port.out.IAccountRepositoryPort;
import co.com.confiar.infrastructure.entity.AccountEntity;
import co.com.confiar.infrastructure.repository.client.IJpaClientRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaAccountRepositoryAdapter implements IAccountRepositoryPort {
    private final IJpaAccountRepository accountRepository;
    private final IJpaClientRepository clientRepository;

    public JpaAccountRepositoryAdapter(IJpaAccountRepository accountRepository, IJpaClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Account> save(Account account) {
        boolean existClient = this.clientRepository.existsById(account.getClientId());
        boolean existAccount = this.accountRepository.existsByAccountNumber(account.getAccountNumber());

        if (existClient && !existAccount) {
            AccountEntity accountEntity = AccountEntity.fromDomainInModel(account);
            AccountEntity savedAccountEntity = this.accountRepository.save(accountEntity);

            return Optional.of(savedAccountEntity.toDomainInModel());
        }

        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        return this.accountRepository.findAll().stream().map(AccountEntity::toDomainInModel).collect(Collectors.toList());
    }
}
