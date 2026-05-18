package com.billion_dollor_company.Bank_Server.psp.service;

import com.billion_dollor_company.Bank_Server.psp.domain.CheckBalanceCommand;
import com.billion_dollor_company.Bank_Server.psp.domain.CheckBalanceResult;
import org.springframework.stereotype.Service;

@Service
public class PSPServiceImpl implements PSPService{
    @Override
    public CheckBalanceResult initiateBalanceInquiry(CheckBalanceCommand command) {
        return null;
    }
}
