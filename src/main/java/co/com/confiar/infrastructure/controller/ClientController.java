package co.com.confiar.infrastructure.controller;

import co.com.confiar.application.services.ClientService;
import co.com.confiar.domain.model.Client;

import co.com.confiar.infrastructure.classes.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api/Client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService client) {
        this.clientService = client;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = this.clientService.getAllClients();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping
    public GenericResponse createClient(@RequestBody Client client) {
        Optional<Client> createdTask = this.clientService.createClient(client);

        if (createdTask.isEmpty()) {
            return new GenericResponse(409, "Ya existe un cliente con está identificación. (NIT)");
        }

        return new GenericResponse(201, createdTask.get());
    }
}
