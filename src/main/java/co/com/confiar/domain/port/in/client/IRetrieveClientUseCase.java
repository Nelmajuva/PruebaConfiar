package co.com.confiar.domain.port.in.client;

import java.util.List;

import co.com.confiar.domain.model.Client;

public interface IRetrieveClientUseCase {
    List<Client> getAllClients();
}
