package co.com.confiar.infrastructure.repository.client;

import co.com.confiar.domain.model.Client;
import co.com.confiar.domain.port.out.IClientRepositoryPort;
import co.com.confiar.infrastructure.entity.ClientEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaClientRepositoryAdapter implements IClientRepositoryPort {
    private final IJpaClientRepository clientRepository;

    public JpaClientRepositoryAdapter(IJpaClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> save(Client client) {
        boolean existClient = this.clientRepository.existsByIdentification(client.getIdentification());

        if (!existClient) {
            ClientEntity clientEntity = ClientEntity.fromDomainInModel(client);
            ClientEntity savedClientEntity = this.clientRepository.save(clientEntity);

            return Optional.of(savedClientEntity.toDomainInModel());
        }

        return Optional.empty();
    }

    @Override
    public List<Client> findAll() {
        return this.clientRepository.findAll().stream().map(ClientEntity::toDomainInModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Client> update(Client client) {
        boolean existsByIdentification = this.clientRepository.existsById(client.getId());

        if (existsByIdentification) {
            ClientEntity clientEntity = ClientEntity.fromDomainInModel(client);
            ClientEntity updateClientEntity = this.clientRepository.save(clientEntity);

            return Optional.of(updateClientEntity.toDomainInModel());
        }

        return Optional.empty();
    }
}
