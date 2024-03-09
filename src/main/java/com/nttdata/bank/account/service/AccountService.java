package com.nttdata.bank.account.service;

import com.nttdata.bank.account.service.model.Account;
import reactor.core.publisher.Mono;

public interface AccountService {
    Mono<Void> saveAccount(Account account);
    Mono<Account> updateAccount(Account account);
    Mono<Account> getAccountById(String accountId);
    Mono<Void> deleteAccount(String accountId);
}
