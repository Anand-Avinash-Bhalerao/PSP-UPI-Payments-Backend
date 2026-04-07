package com.billion_dollor_company.Bank_Server.domain.model;


import lombok.Data;

@Data
public class EncryptedData {
    private String encryptedData;
    private String encryptedKey;
    private String requestId;
}
