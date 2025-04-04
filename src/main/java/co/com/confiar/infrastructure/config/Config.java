package co.com.confiar.infrastructure.config;

import co.com.confiar.application.services.AccountHistoricService;
import co.com.confiar.application.services.AccountService;
import co.com.confiar.application.usecases.account.CreateAccountUseCase;
import co.com.confiar.application.usecases.account.RetrieveAccountUseCase;
import co.com.confiar.application.usecases.account.historic.CreateAccountHistoricUseCase;
import co.com.confiar.application.usecases.account.historic.RetrieveAccountHistoricUseCase;
import co.com.confiar.application.usecases.client.RetrieveClientUseCase;
import co.com.confiar.domain.port.out.IAccountHistoricRepositoryPort;
import co.com.confiar.domain.port.out.IAccountRepositoryPort;
import co.com.confiar.infrastructure.repository.account.JpaAccountRepositoryAdapter;
import co.com.confiar.infrastructure.repository.account.historic.JpaAccountHistoricRepositoryAdapter;
import co.com.confiar.infrastructure.repository.client.JpaClientRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.confiar.application.services.ClientService;
import co.com.confiar.application.usecases.client.CreateClientUseCase;
import co.com.confiar.application.usecases.client.UpdateClientUseCase;
import co.com.confiar.domain.port.out.IClientRepositoryPort;

@Configuration
public class Config {

    @Bean
    public ClientService clientService(IClientRepositoryPort clientRepositoryPort) {
        return new ClientService(
                new CreateClientUseCase(clientRepositoryPort),
                new RetrieveClientUseCase(clientRepositoryPort),
                new UpdateClientUseCase(clientRepositoryPort));
    }

    @Bean
    public AccountService accountService(IAccountRepositoryPort accountRepositoryPort) {
        return new AccountService(
                new CreateAccountUseCase(accountRepositoryPort),
                new RetrieveAccountUseCase(accountRepositoryPort));
    }

    @Bean
    public AccountHistoricService accountHistoricService(IAccountHistoricRepositoryPort accountHistoricRepositoryPort) {
        return new AccountHistoricService(
                new CreateAccountHistoricUseCase(accountHistoricRepositoryPort),
                new RetrieveAccountHistoricUseCase(accountHistoricRepositoryPort));
    }

    @Bean
    public IClientRepositoryPort clientRepositoryPort(JpaClientRepositoryAdapter clientRepositoryAdapter) {
        return clientRepositoryAdapter;
    }

    @Bean
    public IAccountRepositoryPort accountRepositoryPort(JpaAccountRepositoryAdapter accountRepositoryAdapter) {
        return accountRepositoryAdapter;
    }

    @Bean
    public IAccountHistoricRepositoryPort accountHistoricRepositoryPort(JpaAccountHistoricRepositoryAdapter accountHistoricRepositoryAdapter) {
        return accountHistoricRepositoryAdapter;
    }

}
