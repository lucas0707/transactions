package com.lucas.transaction.unit.domain.entities;

import com.lucas.transaction.domain.entities.operationType.OperationDescription;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OperationDescriptionTests {

    @Test
    public void testOperationDescriptionEnumCompraAVista() {
        var expected = OperationDescription.COMPRA_A_VISTA;
        var actual = OperationDescription.valueOf("COMPRA_A_VISTA");

        assertEquals(expected, actual);
    }

    @Test
    public void testOperationDescriptionEnumCompraParcelada() {
        var expected = OperationDescription.COMPRA_PARCELADA;
        var actual = OperationDescription.valueOf("COMPRA_PARCELADA");

        assertEquals(expected, actual);
    }

    @Test
    public void testOperationDescriptionEnumSaque() {
        var expected = OperationDescription.SAQUE;
        var actual = OperationDescription.valueOf("SAQUE");

        assertEquals(expected, actual);
    }

    @Test
    public void testOperationDescriptionEnumPagamento() {
        var expected = OperationDescription.PAGAMENTO;
        var actual = OperationDescription.valueOf("PAGAMENTO");

        assertEquals(expected, actual);
    }

}
