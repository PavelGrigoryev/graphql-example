package com.grigoryev.graphqlexample.controller;

import com.grigoryev.graphqlexample.model.BankAccount;
import com.grigoryev.graphqlexample.model.Currency;
import com.grigoryev.graphqlexample.model.DeleteResponse;
import com.grigoryev.graphqlexample.service.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public record BankAccountController(BankAccountService bankAccountService) {

    @MutationMapping
    public Mono<BankAccount> save(@Argument String name, @Argument Currency currency) {
        return bankAccountService.save(name, currency);
    }

    @QueryMapping
    public Mono<BankAccount> findById(@Argument String id) {
        return bankAccountService.findById(id);
    }

    @MutationMapping
    public Mono<BankAccount> updateById(@Argument String id, @Argument String name, @Argument Currency currency) {
        return bankAccountService.updateById(id, name, currency);
    }

    @MutationMapping
    public Mono<DeleteResponse> deleteById(@Argument String id) {
        return bankAccountService.deleteById(id);
    }

    @QueryMapping
    public Flux<BankAccount> findAll(@Argument Integer skip, @Argument Integer limit) {
        return bankAccountService.findAll(skip, limit);
    }

}
