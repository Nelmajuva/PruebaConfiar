package co.com.confiar.application.usecases.client;

import co.com.confiar.domain.model.Client;
import co.com.confiar.domain.port.in.client.IRetrieveClientUseCase;
import co.com.confiar.domain.port.out.IClientRepositoryPort;

import java.util.List;

public class RetrieveClientUseCase implements IRetrieveClientUseCase {
    private final IClientRepositoryPort clientRepositoryPort;

    public RetrieveClientUseCase(IClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public List<Client> getAllClients() {
        return  this.clientRepositoryPort.findAll();
    }
}
