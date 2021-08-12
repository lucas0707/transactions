package com.lucas.transaction.domain.entities.operationType;

import java.io.Serializable;

public class OperationType implements Serializable {
    private int operationTypeId;

    private String description;

    public OperationType() {}

    public OperationType(String description) {
        this.description = description;
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public String getDescription() {
        return description;
    }
}
