package com.lucas.transaction.domain.entities.account;

import java.io.Serializable;

public class Account implements Serializable {
    private Long accountId;

    private String documentNumber;

    public Account(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Account(Long accountId, String documentNumber)
    {
        this.accountId = accountId;
        this.documentNumber = documentNumber;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
}
