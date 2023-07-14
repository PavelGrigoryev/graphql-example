package com.grigoryev.graphqlexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("bank_accounts")
public class BankAccount {

    private String id;
    private String name;
    private Currency currency;

}
