package com.grigoryev.graphqlexample.repository;

import com.grigoryev.graphqlexample.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
}
