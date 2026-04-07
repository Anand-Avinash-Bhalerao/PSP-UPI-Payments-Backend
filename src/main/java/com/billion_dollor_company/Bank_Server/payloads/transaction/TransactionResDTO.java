package com.billion_dollor_company.Bank_Server.payloads.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResDTO {
    public String status;
    public String message;
}
