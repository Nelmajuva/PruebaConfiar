package co.com.confiar.domain.port.in.client;

import co.com.confiar.domain.model.Client;

import java.util.Optional;

public interface ICreateClientUseCase {
    Optional<Client> createClient(Client client);
}
