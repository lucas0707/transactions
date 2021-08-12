package com.lucas.transaction.adapter.DTO.account;

public class CreateAccountRequestDTO {
    public String document_number;

    public CreateAccountRequestDTO(String document_number) {
        this.document_number = document_number;
    }

    public String getDocumentNumber() {
        return document_number;
    }
}
