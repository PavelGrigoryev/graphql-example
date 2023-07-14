package com.grigoryev.graphqlexample.exception;

public class NoSuchBankAccountException extends RuntimeException {

    public NoSuchBankAccountException(String message) {
        super(message);
    }

}
