package com.lucas.transaction.domain.ports;

public interface OperationTypeRepository {
    boolean hasOperationType(int operationTypeId) throws Exception;
}
