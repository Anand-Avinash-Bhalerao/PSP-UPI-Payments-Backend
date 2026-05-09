package com.billion_dollor_company.Bank_Server.psp.service.impl;

import com.billion_dollor_company.Bank_Server.common.exceptions.customExceptions.DataNotFoundException;
import com.billion_dollor_company.Bank_Server.domain.model.EncryptedData;
import com.billion_dollor_company.Bank_Server.payloads.AccountBasicDTO;
import com.billion_dollor_company.Bank_Server.common.repository.models.projections.AccountBasicProjection;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceResDTO;
import com.billion_dollor_company.Bank_Server.payloads.fetchKeys.FetchKeysResDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationResDTO;
import com.billion_dollor_company.Bank_Server.payloads.transaction.TransactionReqDTO;
import com.billion_dollor_company.Bank_Server.common.repository.AccountInfoRepository;
import com.billion_dollor_company.Bank_Server.npci.service.NpciApiService;
import com.billion_dollor_company.Bank_Server.psp.payloads.checkbalance.CheckBalanceResDTO;
import com.billion_dollor_company.Bank_Server.psp.payloads.transaction.TransactionResDTO;
import com.billion_dollor_company.Bank_Server.psp.service.PSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PSPServiceImpl implements PSPService {

    @Autowired
    private final AccountInfoRepository accountInfoRepository;

    @Autowired
    private final NpciApiService npciApiService;

    public PSPServiceImpl(AccountInfoRepository accountInfoRepository, NpciApiService npciApiService) {
        this.accountInfoRepository = accountInfoRepository;
        this.npciApiService = npciApiService;
    }

    @Override
    public CheckBalanceResDTO initiateCheckBalanceInquiry(EncryptedData encryptedData) {
        return npciApiService.initiateCheckBalanceInquiry(encryptedData);
    }

}
