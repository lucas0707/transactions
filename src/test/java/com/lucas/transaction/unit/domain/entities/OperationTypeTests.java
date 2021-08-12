package com.lucas.transaction.unit.domain.entities;

import com.lucas.transaction.domain.entities.operationType.OperationDescription;
import com.lucas.transaction.domain.entities.operationType.OperationType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OperationTypeTests {
    @Test
    public void testGettersAndSetters() {
        var operationId = 1;
        var description = OperationDescription.COMPRA_A_VISTA;
        var operationType = new OperationType(operationId, description);

        assertEquals(operationId, operationType.getOperationTypeId());
        assertEquals(description, operationType.getDescription());
    }

    @Test
    public void testGettersAndSettersDescription() {
        var description = OperationDescription.COMPRA_A_VISTA;
        var operationType = new OperationType(description);

        assertEquals(description, operationType.getDescription());
    }
}
