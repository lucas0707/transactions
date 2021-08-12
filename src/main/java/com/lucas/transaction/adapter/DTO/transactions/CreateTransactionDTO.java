package com.lucas.transaction.adapter.DTO.transactions;

public class CreateTransactionDTO {
    public Long account_id;
    public int operation_type_id;
    public double amount;

    public CreateTransactionDTO(Long account_id, int operation_type_id, double amount) {
        this.account_id = account_id;
        this.operation_type_id = operation_type_id;
        this.amount = amount;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public int getOperationTypeId() {
        return operation_type_id;
    }

    public double getAmount() {
        return amount;
    }
}
