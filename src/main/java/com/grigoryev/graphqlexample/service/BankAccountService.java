package com.grigoryev.graphqlexample.service;

import com.grigoryev.graphqlexample.model.BankAccount;
import com.grigoryev.graphqlexample.model.Currency;
import com.grigoryev.graphqlexample.model.DeleteResponse;

import java.util.List;

public interface BankAccountService {

    BankAccount save(String name, Currency currency);

    BankAccount findById(String id);

    BankAccount updateById(String id, String name, Currency currency);

    DeleteResponse deleteById(String id);

    List<BankAccount> findAll();

}
