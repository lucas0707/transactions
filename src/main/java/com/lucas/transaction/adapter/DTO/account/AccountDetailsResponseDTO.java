package com.lucas.transaction.adapter.DTO.account;

public class AccountDetailsResponseDTO {
    private final Long account_id;
    private final String document_number;

    public AccountDetailsResponseDTO(Long account_id, String document_number) {
        this.account_id = account_id;
        this.document_number = document_number;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public String getDocument_number() {
        return document_number;
    }
}
