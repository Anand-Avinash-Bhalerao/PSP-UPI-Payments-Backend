package com.billion_dollor_company.Bank_Server.psp.controller;


import com.billion_dollor_company.Bank_Server.common.exceptions.customExceptions.AccountBasicRequestException;
import com.billion_dollor_company.Bank_Server.common.exceptions.customExceptions.RegistrationRequestException;
import com.billion_dollor_company.Bank_Server.common.exceptions.customExceptions.TransactionRequestException;
import com.billion_dollor_company.Bank_Server.domain.model.EncryptedData;
import com.billion_dollor_company.Bank_Server.payloads.AccountBasicDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceResDTO;
import com.billion_dollor_company.Bank_Server.payloads.fetchKeys.FetchKeysResDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationResDTO;
import com.billion_dollor_company.Bank_Server.payloads.transaction.TransactionReqDTO;
import com.billion_dollor_company.Bank_Server.psp.mappers.PSPMapper;
import com.billion_dollor_company.Bank_Server.psp.payloads.EncryptedReqDTO;
import com.billion_dollor_company.Bank_Server.psp.payloads.checkbalance.CheckBalanceResDTO;
import com.billion_dollor_company.Bank_Server.psp.payloads.transaction.TransactionResDTO;
import com.billion_dollor_company.Bank_Server.psp.service.PSPService;
import com.billion_dollor_company.Bank_Server.common.util.Constants;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 * REST Controller for PSP operations.
 */
@RestController
@RequestMapping(
        value = "/psp",
        produces = {"application/json"}
)
@Slf4j
public class PSPController {

    private final PSPService pspService;

    private final PSPMapper pspMapper;

    @Autowired
    public PSPController(PSPService pspService, PSPMapper pspMapper) {
        this.pspService = pspService;
        this.pspMapper = pspMapper;
    }

    @PostMapping("/checkBalance")
    public CheckBalanceResDTO getAccountBalance(@Valid @RequestBody EncryptedReqDTO checkBalanceDTO) {

        EncryptedData encryptedData = pspMapper.mapEncryptedReqDtoToEncryptedData(checkBalanceDTO);
        return pspService.initiateCheckBalanceInquiry(encryptedData);

    }

}
