package com.nttdata.bank.account.repository;

import com.nttdata.bank.account.repository.entity.AccountEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepository extends ReactiveMongoRepository<AccountEntity,String> {
}
