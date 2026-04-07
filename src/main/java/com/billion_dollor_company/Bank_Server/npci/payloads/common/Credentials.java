package com.billion_dollor_company.Bank_Server.npci.payloads.common;

import lombok.Data;

@Data
public class Credentials {
    private String type;
    private String encryptedPassword;
}
