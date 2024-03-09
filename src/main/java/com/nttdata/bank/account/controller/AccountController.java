package com.nttdata.bank.account.controller;

import com.nttdata.bank.account.controller.dto.AccountDto;
import com.nttdata.bank.account.service.AccountService;
import com.nttdata.bank.account.service.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @PostMapping
    public Mono<Void> createAccount(@RequestBody AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        return accountService.saveAccount(account);
    }

    @PutMapping
    public Mono<Account> updateAccount(@RequestBody AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        return accountService.updateAccount(account);
    }

    @GetMapping("/{clientId}")
    public Mono<Account> getAccountById(@PathVariable String accountId) {
        return accountService.getAccountById(accountId);
    }
    @GetMapping("/{clientId}")
    public Mono<Void> removeAccount(@PathVariable String accountId) {
        return accountService.deleteAccount(accountId);
    }
}
