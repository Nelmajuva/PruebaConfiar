package co.com.confiar.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.com.confiar.domain.port.in.client.IUpdateClientUseCase;
import org.springframework.stereotype.Service;

import co.com.confiar.domain.model.Client;
import co.com.confiar.domain.port.in.client.ICreateClientUseCase;
import co.com.confiar.domain.port.in.client.IRetrieveClientUseCase;

@Service
public class ClientService implements ICreateClientUseCase, IUpdateClientUseCase, IRetrieveClientUseCase {

    private final IRetrieveClientUseCase retrieveClientUseCase;
    private final ICreateClientUseCase createClientUseCase;
    private final IUpdateClientUseCase updateClientUseCase;

    public ClientService(ICreateClientUseCase createClientUseCase, IRetrieveClientUseCase retrieveClientUseCase, IUpdateClientUseCase updateClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
        this.retrieveClientUseCase = retrieveClientUseCase;
    }

    @Override
    public List<Client> getAllClients() {
        return this.retrieveClientUseCase.getAllClients();
    }

    @Override
    public Optional<Client> updateClient(UUID id, Client client) {
        return this.updateClientUseCase.updateClient(id, client);
    }

    @Override
    public Optional<Client> createClient(Client client) {
        return this.createClientUseCase.createClient(client);
    }
}
