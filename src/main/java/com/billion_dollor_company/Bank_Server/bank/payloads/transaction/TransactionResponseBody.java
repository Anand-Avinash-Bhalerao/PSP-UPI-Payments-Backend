package com.billion_dollor_company.Bank_Server.bank.payloads.transaction;

import com.billion_dollor_company.Bank_Server.common.payload.response.ResponseBody;
import lombok.Data;

@Data
public class TransactionResponseBody implements ResponseBody {
    private String transactionId;
    private String payeeUpiID;
    private String payerUpiID;
    private Double amount;
}
