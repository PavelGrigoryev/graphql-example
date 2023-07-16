package com.grigoryev.graphqlexample.repository;

import com.grigoryev.graphqlexample.model.BankAccount;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {

    @Aggregation({"{ $skip: ?0 }", "{ $limit: ?1 }"})
    Flux<BankAccount> findAll(Integer skip, Integer limit);

}
