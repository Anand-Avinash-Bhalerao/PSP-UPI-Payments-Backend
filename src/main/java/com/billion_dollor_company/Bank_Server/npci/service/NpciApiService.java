package com.billion_dollor_company.Bank_Server.npci.service;

import com.billion_dollor_company.Bank_Server.domain.model.EncryptedData;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceResDTO;
import com.billion_dollor_company.Bank_Server.payloads.fetchKeys.FetchKeysResDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationResDTO;
import com.billion_dollor_company.Bank_Server.payloads.transaction.TransactionReqDTO;
import com.billion_dollor_company.Bank_Server.psp.payloads.checkbalance.CheckBalanceResDTO;
import com.billion_dollor_company.Bank_Server.psp.payloads.transaction.TransactionResDTO;

public interface NpciApiService {
//    TransactionResDTO initiateTransaction2(TransactionReqDTO requestInfo);

//    BalanceResDTO getAccountBalance(BalanceReqDTO requestInfo);

    RegistrationResDTO register(RegistrationReqDTO requestInfo);
    FetchKeysResDTO fetchKeys();

    CheckBalanceResDTO initiateCheckBalanceInquiry(EncryptedData encryptedData);

    TransactionResDTO initiateTransaction(EncryptedData encryptedData);
}
