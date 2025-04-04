package co.com.confiar.domain.port.in.client;

import java.util.Optional;
import java.util.UUID;

import co.com.confiar.domain.model.Client;

public interface IUpdateClientUseCase {
    Optional<Client> updateClient(UUID id, Client client);
}
