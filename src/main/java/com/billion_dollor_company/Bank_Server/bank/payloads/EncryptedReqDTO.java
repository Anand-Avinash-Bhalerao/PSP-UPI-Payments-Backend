package com.billion_dollor_company.Bank_Server.bank.payloads;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EncryptedReqDTO {

    @NotBlank(message = "Encrypted data cannot be blank")
    private String encryptedData;

    @NotBlank(message = "Encrypted key cannot be blank")
    private String encryptedKey;

    @NotBlank(message = "Request ID cannot be blank")
    private String requestId;
}
