package com.grigoryev.graphqlexample.controller;

import com.grigoryev.graphqlexample.model.BankAccount;
import com.grigoryev.graphqlexample.model.Currency;
import com.grigoryev.graphqlexample.model.DeleteResponse;
import com.grigoryev.graphqlexample.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @MutationMapping
    public Mono<BankAccount> save(@Argument String name, @Argument Currency currency) {
        log.info("Args: name={}, currency={}", name, currency);
        return bankAccountService.save(name, currency);
    }

    @QueryMapping
    public Mono<BankAccount> findById(@Argument String id) {
        log.info("Args: id={}", id);
        return bankAccountService.findById(id);
    }

    @MutationMapping
    public Mono<BankAccount> updateById(@Argument String id, @Argument String name, @Argument Currency currency) {
        log.info("Args: id={}, name={}, currency={}", id, name, currency);
        return bankAccountService.updateById(id, name, currency);
    }

    @MutationMapping
    public Mono<DeleteResponse> deleteById(@Argument String id) {
        log.info("Args: id={}", id);
        return bankAccountService.deleteById(id);
    }

    @QueryMapping
    public Flux<BankAccount> findAll() {
        return bankAccountService.findAll();
    }

}
