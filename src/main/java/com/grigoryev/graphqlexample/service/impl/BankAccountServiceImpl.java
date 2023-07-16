package com.grigoryev.graphqlexample.service.impl;

import com.grigoryev.graphqlexample.exception.NoSuchBankAccountException;
import com.grigoryev.graphqlexample.model.BankAccount;
import com.grigoryev.graphqlexample.model.Currency;
import com.grigoryev.graphqlexample.model.DeleteResponse;
import com.grigoryev.graphqlexample.repository.BankAccountRepository;
import com.grigoryev.graphqlexample.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public Mono<BankAccount> save(String name, Currency currency) {
        BankAccount bankAccount = BankAccount.builder()
                .name(name)
                .currency(currency)
                .build();
        return bankAccountRepository.save(bankAccount)
                .log("BankAccountServiceImpl save:");
    }

    @Override
    public Mono<BankAccount> findById(String id) {
        return bankAccountRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new NoSuchBankAccountException("BankAccount with ID " + id + " does not exist")))
                .log("BankAccountServiceImpl findById:");
    }

    @Override
    @Transactional
    public Mono<BankAccount> updateById(String id, String name, Currency currency) {
        return findById(id)
                .map(bankAccount -> {
                    bankAccount.setName(name);
                    bankAccount.setCurrency(currency);
                    return bankAccount;
                })
                .flatMap(bankAccountRepository::save)
                .log("BankAccountServiceImpl updateById:");
    }

    @Override
    @Transactional
    public Mono<DeleteResponse> deleteById(String id) {
        return findById(id)
                .flatMap(bankAccountRepository::delete)
                .thenReturn(new DeleteResponse("BankAccount with ID " + id + " was successfully deleted"))
                .log("BankAccountServiceImpl deleteById:");
    }

    @Override
    public Flux<BankAccount> findAll() {
        return bankAccountRepository.findAll()
                .log("BankAccountServiceImpl findAll:");
    }

}
