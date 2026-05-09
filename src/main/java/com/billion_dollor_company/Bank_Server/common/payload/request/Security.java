package com.billion_dollor_company.Bank_Server.common.payload.request;

import lombok.Data;

@Data
public class Security {
    private String signature;
    private String encryptionMethod;
}
