package com.grigoryev.graphqlexample.controller;

import com.grigoryev.graphqlexample.model.BankAccount;
import com.grigoryev.graphqlexample.model.Currency;
import com.grigoryev.graphqlexample.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @MutationMapping
    public BankAccount save(@Argument String name, @Argument Currency currency) {
        log.info("Args: name={}, currency={}", name, currency);
        return bankAccountService.save(name, currency);
    }

    @QueryMapping
    public BankAccount findById(@Argument String id) {
        log.info("Args: id={}", id);
        return bankAccountService.findById(id);
    }

    @MutationMapping
    public BankAccount updateById(@Argument String id, @Argument String name, @Argument Currency currency) {
        log.info("Args: id={}, name={}, currency={}", id, name, currency);
        return bankAccountService.updateById(id, name, currency);
    }

}
