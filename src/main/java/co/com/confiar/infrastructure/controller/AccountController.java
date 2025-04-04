package co.com.confiar.infrastructure.controller;

import co.com.confiar.application.services.AccountService;
import co.com.confiar.domain.model.Account;
import co.com.confiar.infrastructure.classes.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api/Account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = this.accountService.getAllAccounts();

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping
    public GenericResponse createAccount(@RequestBody Account account) {
        Optional<Account> createdAccount = this.accountService.createAccount(account);

        if (createdAccount.isEmpty()) {
            return new GenericResponse(409, "Por favor, validar que el cliente exista o no exista previamente una cuenta de ahorros con este número: " + account.getAccountNumber());
        }

        return new GenericResponse(201, createdAccount.get());
    }
}
