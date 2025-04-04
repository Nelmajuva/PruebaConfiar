package co.com.confiar.infrastructure.controller;

import co.com.confiar.application.services.AccountHistoricService;
import co.com.confiar.domain.model.AccountHistoric;
import co.com.confiar.infrastructure.classes.GenericResponse;
import co.com.confiar.infrastructure.enums.TypeHistoric;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api/AccountHistoric")
public class AccountHistoricController {
    private final AccountHistoricService accountHistoricService;

    public AccountHistoricController(AccountHistoricService accountHistoricService) {
        this.accountHistoricService = accountHistoricService;
    }

    @GetMapping
    public ResponseEntity<List<AccountHistoric>> getAllAccountsHistoric() {
        List<AccountHistoric> accountsHistoric = this.accountHistoricService.getAllAccountsHistoric();

        return new ResponseEntity<>(accountsHistoric, HttpStatus.OK);
    }

    @PostMapping
    public GenericResponse createAccountHistoric(@RequestBody AccountHistoric accountHistoric) {
        Optional<AccountHistoric> createdAccountHistoric = this.accountHistoricService.createAccountHistoric(accountHistoric);

        if (createdAccountHistoric.isEmpty()) {
            var message = accountHistoric.getTypeHistoric() == TypeHistoric.CR ? "La transacción no fue válida. Por favor, verifique que la cuenta exista." : "La transacción no fue válida. Por favor, verifique que la cuenta exista o que tenga fondos suficientes para realizar la operación.";
            return new GenericResponse(409, message);
        }

        return new GenericResponse(201, createdAccountHistoric.get());
    }
}
