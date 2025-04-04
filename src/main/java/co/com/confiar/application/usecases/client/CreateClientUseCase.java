package co.com.confiar.application.usecases.client;

import co.com.confiar.domain.model.Client;
import co.com.confiar.domain.port.in.client.ICreateClientUseCase;
import co.com.confiar.domain.port.out.IClientRepositoryPort;

import java.util.Optional;

public class CreateClientUseCase implements ICreateClientUseCase {

    private final IClientRepositoryPort clientRepositoryPort;

    public CreateClientUseCase(IClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> createClient(Client task) {
        return clientRepositoryPort.save(task);
    }

}
