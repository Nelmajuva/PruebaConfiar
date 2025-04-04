package co.com.confiar.infrastructure.repository.account.historic;

import co.com.confiar.domain.model.AccountHistoric;
import co.com.confiar.domain.port.out.IAccountHistoricRepositoryPort;
import co.com.confiar.infrastructure.entity.AccountEntity;
import co.com.confiar.infrastructure.entity.AccountHistoricEntity;
import co.com.confiar.infrastructure.enums.TypeHistoric;
import co.com.confiar.infrastructure.repository.account.IJpaAccountRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaAccountHistoricRepositoryAdapter implements IAccountHistoricRepositoryPort {
    private final IJpaAccountRepository accountRepository;
    private final IJpaAccountHistoricRepository accountHistoricRepository;

    public JpaAccountHistoricRepositoryAdapter(IJpaAccountHistoricRepository accountHistoricRepository, IJpaAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.accountHistoricRepository = accountHistoricRepository;
    }

    @Override
    public Optional<AccountHistoric> save(AccountHistoric accountHistoric) {
        boolean existAccount = this.accountRepository.existsById(accountHistoric.getAccountId());

        if (!existAccount) {
            return Optional.empty();
        }

        AccountEntity account = this.accountRepository.getReferenceById(accountHistoric.getAccountId());

        if (accountHistoric.getTypeHistoric() == TypeHistoric.DB) {
            if (account.getAvailableBalance() < accountHistoric.getAmount()) {
                return Optional.empty();
            }

            account.setAvailableBalance(account.getAvailableBalance() - accountHistoric.getAmount());
            this.accountRepository.save(account);
        } else {
            account.setAvailableBalance(account.getAvailableBalance() + accountHistoric.getAmount());
            this.accountRepository.save(account);
        }

        AccountHistoricEntity accountHistoricEntity = AccountHistoricEntity.fromDomainInModel(accountHistoric);
        AccountHistoricEntity savedAccountHistoricEntity = this.accountHistoricRepository.save(accountHistoricEntity);

        return Optional.of(savedAccountHistoricEntity.toDomainInModel());
    }

    @Override
    public List<AccountHistoric> findAll() {
        return this.accountHistoricRepository.findAll().stream().map(AccountHistoricEntity::toDomainInModel).collect(Collectors.toList());
    }
}
