package com.billion_dollor_company.Bank_Server.bank.service;

import com.billion_dollor_company.Bank_Server.bank.payloads.checkbalance.request.CheckBalanceReqBody;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceResDTO;
import com.billion_dollor_company.Bank_Server.payloads.transaction.TransactionReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.transaction.TransactionResDTO;

public interface BankService {
    TransactionResDTO initiateTransaction(TransactionReqDTO requestInfo);

    BalanceResDTO getAccountBalance(CheckBalanceReqBody requestInfo);
}
