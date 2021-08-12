package com.lucas.transaction.exceptions.domain;

public class OperationTypeNotFoundException extends DomainException {
    public OperationTypeNotFoundException() {
        super( "Operation Type not found.");
    }
}
