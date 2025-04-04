package co.com.confiar.domain.port.out;

import java.util.List;
import java.util.Optional;

import co.com.confiar.domain.model.Client;

public interface IClientRepositoryPort {
    Optional<Client> save(Client client);

    List<Client> findAll();

    Optional<Client> update(Client client);
}
