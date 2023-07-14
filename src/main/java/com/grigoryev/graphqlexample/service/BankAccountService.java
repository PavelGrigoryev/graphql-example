package com.grigoryev.graphqlexample.service;

import com.grigoryev.graphqlexample.model.BankAccount;
import com.grigoryev.graphqlexample.model.Currency;

public interface BankAccountService {

    BankAccount save(String name, Currency currency);

    BankAccount findById(String id);

    BankAccount updateById(String id, String name, Currency currency);

}
