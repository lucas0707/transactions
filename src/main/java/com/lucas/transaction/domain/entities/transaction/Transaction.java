package com.lucas.transaction.domain.entities.transaction;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private Long transactionId;

    private final double amount;

    private final Long accountId;

    private final int operationTypeId;

    private final Date eventDate;

    public Transaction(double amount, Long accountId, int operationTypeId) {
        this.amount = amount;
        this.accountId = accountId;
        this.operationTypeId = operationTypeId;
        this.eventDate = new Date();
    }

    public Transaction(Long transactionId, double amount, Long accountId, int operationTypeId, Date eventDate) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.accountId = accountId;
        this.operationTypeId = operationTypeId;
        this.eventDate = eventDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public Date getEventDate() {
        return eventDate;
    }
}
