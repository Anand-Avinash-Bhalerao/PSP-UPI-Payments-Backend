package com.billion_dollor_company.Bank_Server.bank.payloads.checkbalance.response;

import com.billion_dollor_company.Bank_Server.common.payload.response.ResponseBody;
import lombok.Data;

@Data
public class CheckBalanceResponseBody implements ResponseBody {
    private String upiID;
    private double balance;
}
