package com.billion_dollor_company.Bank_Server.psp.service;

import com.billion_dollor_company.Bank_Server.domain.model.EncryptedData;
import com.billion_dollor_company.Bank_Server.payloads.AccountBasicDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceResDTO;
import com.billion_dollor_company.Bank_Server.payloads.fetchKeys.FetchKeysResDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationResDTO;
import com.billion_dollor_company.Bank_Server.payloads.transaction.TransactionReqDTO;
import com.billion_dollor_company.Bank_Server.psp.payloads.transaction.TransactionResDTO;
import com.billion_dollor_company.Bank_Server.psp.payloads.checkbalance.CheckBalanceResDTO;

public interface PSPService {
    CheckBalanceResDTO initiateCheckBalanceInquiry(EncryptedData encryptedData);
}
