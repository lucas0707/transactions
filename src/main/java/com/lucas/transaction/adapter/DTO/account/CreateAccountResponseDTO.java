package com.lucas.transaction.adapter.DTO.account;

public class CreateAccountResponseDTO {
    private final String document_number;
    private final Long account_id;

    public CreateAccountResponseDTO(String document_number, Long account_id) {
        this.document_number = document_number;
        this.account_id = account_id;
    }

    public String getDocument_number()
    {
        return document_number;
    }

    public Long getAccount_id()
    {
        return account_id;
    }
}
