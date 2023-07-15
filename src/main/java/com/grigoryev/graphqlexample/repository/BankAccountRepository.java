package com.grigoryev.graphqlexample.repository;

import com.grigoryev.graphqlexample.model.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
}
