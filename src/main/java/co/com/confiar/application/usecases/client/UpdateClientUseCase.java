package co.com.confiar.application.usecases.client;

import java.util.Optional;
import java.util.UUID;

import co.com.confiar.domain.port.in.client.IUpdateClientUseCase;
import co.com.confiar.domain.model.Client;
import co.com.confiar.domain.port.out.IClientRepositoryPort;

public class UpdateClientUseCase implements IUpdateClientUseCase {
    
    private final IClientRepositoryPort clientRepositoryPort;

    public UpdateClientUseCase(IClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> updateClient(UUID id, Client task) {
        return this.clientRepositoryPort.update(task);
    }

}
