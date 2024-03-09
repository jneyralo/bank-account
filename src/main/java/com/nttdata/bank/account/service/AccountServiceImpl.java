package com.nttdata.bank.account.service;

import com.nttdata.bank.account.repository.AccountRepository;
import com.nttdata.bank.account.repository.entity.AccountEntity;
import com.nttdata.bank.account.service.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    @Override
    public Mono<Void> saveAccount(Account account) {
        AccountEntity accountEntity=new AccountEntity();
        BeanUtils.copyProperties(account,accountEntity);
        return accountRepository.save(accountEntity).then();
    }

    @Override
    public Mono<Account> updateAccount(Account account) {
        AccountEntity accountEntity=new AccountEntity();
        BeanUtils.copyProperties(account,accountEntity);
        return accountRepository.findById(account.getAccountId())
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(accountOptional->{
                    if(accountOptional.isPresent()){
                        account.setAccountId(account.getAccountId());
                        return accountRepository.save(accountEntity);
                    }
                    return Mono.empty();
                })
                .map(accountEntity1 -> {
                    Account account1=new Account();
                    BeanUtils.copyProperties(accountEntity1,account1);
                    return account1;
                });
    }

    @Override
    public Mono<Account> getAccountById(String accountId) {
        return accountRepository.findById(accountId)
                .map(accountEntity -> {
                    Account account=new Account();
                    BeanUtils.copyProperties(accountEntity, account);
                    return account;
                });
    }

    @Override
    public Mono<Void> deleteAccount(String accountId) {
        return accountRepository.deleteById(accountId);
    }
}
