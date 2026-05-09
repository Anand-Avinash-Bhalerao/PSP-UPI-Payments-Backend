package com.billion_dollor_company.Bank_Server.npci.payloads.checkBalance;

import com.billion_dollor_company.Bank_Server.common.payload.request.RequestBody;
import com.billion_dollor_company.Bank_Server.npci.payloads.common.Credentials;
import lombok.Data;

@Data
public class CheckBalanceBody implements RequestBody {
    private AccountHolder accountHolder;
    private Credentials credentials;
}
