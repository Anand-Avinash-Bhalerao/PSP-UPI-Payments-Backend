package com.billion_dollor_company.Bank_Server.bank.controller;


import com.billion_dollor_company.Bank_Server.bank.payloads.checkbalance.request.CheckBalanceReqBody;
import com.billion_dollor_company.Bank_Server.bank.payloads.checkbalance.response.CheckBalanceResDTO;
import com.billion_dollor_company.Bank_Server.bank.service.BankService;
import com.billion_dollor_company.Bank_Server.common.payload.request.BaseReqDTO;
import com.billion_dollor_company.Bank_Server.common.util.Constants;
import com.billion_dollor_company.Bank_Server.common.util.MessagePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bank", produces = {"application/json"})
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/checkBalance")
    public ResponseEntity<CheckBalanceResDTO> getAccountBalance(@RequestBody BaseReqDTO<CheckBalanceReqBody> request) {
        bankService.getAccountBalance(request.getBody());
        return ResponseEntity.ok(null);
    }
}