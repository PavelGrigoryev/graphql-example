package com.grigoryev.graphqlexample.service.impl;

import com.grigoryev.graphqlexample.exception.NoSuchBankAccountException;
import com.grigoryev.graphqlexample.model.BankAccount;
import com.grigoryev.graphqlexample.model.Currency;
import com.grigoryev.graphqlexample.repository.BankAccountRepository;
import com.grigoryev.graphqlexample.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public BankAccount save(String name, Currency currency) {
        BankAccount bankAccount = BankAccount.builder()
                .name(name)
                .currency(currency)
                .build();
        BankAccount saved = bankAccountRepository.save(bankAccount);
        log.info("Save: {}", saved);
        return saved;
    }

    @Override
    public BankAccount findById(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new NoSuchBankAccountException("BankAccount with ID " + id + " does not exist"));
        log.info("FindById: {}", bankAccount);
        return bankAccount;
    }

    @Override
    public BankAccount updateById(String id, String name, Currency currency) {
        BankAccount bankAccount = findById(id);
        bankAccount.setName(name);
        bankAccount.setCurrency(currency);
        BankAccount updated = bankAccountRepository.save(bankAccount);
        log.info("UpdateById: {}", updated);
        return updated;
    }

}
