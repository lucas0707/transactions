package com.lucas.transaction.domain.entities.operationType;

import java.io.Serializable;

public class OperationType implements Serializable {
    private int operationTypeId;

    private final OperationDescription description;

    public OperationType(OperationDescription description) {
        this.description = description;
    }

    public OperationType(int operationTypeId, OperationDescription description) {
        this.operationTypeId = operationTypeId;
        this.description = description;
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public OperationDescription getDescription() {
        return description;
    }
}
