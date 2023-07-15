package com.grigoryev.graphqlexample.service;

import com.grigoryev.graphqlexample.model.BankAccount;
import com.grigoryev.graphqlexample.model.Currency;
import com.grigoryev.graphqlexample.model.DeleteResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountService {

    Mono<BankAccount> save(String name, Currency currency);

    Mono<BankAccount> findById(String id);

    Mono<BankAccount> updateById(String id, String name, Currency currency);

    Mono<DeleteResponse> deleteById(String id);

    Flux<BankAccount> findAll();

}
