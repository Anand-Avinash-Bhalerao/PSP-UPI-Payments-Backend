package com.billion_dollor_company.Bank_Server.psp.controller;


import com.billion_dollor_company.Bank_Server.common.exceptions.customExceptions.AccountBasicRequestException;
import com.billion_dollor_company.Bank_Server.common.exceptions.customExceptions.RegistrationRequestException;
import com.billion_dollor_company.Bank_Server.common.exceptions.customExceptions.TransactionRequestException;
import com.billion_dollor_company.Bank_Server.payloads.AccountBasicDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.checkBalance.BalanceResDTO;
import com.billion_dollor_company.Bank_Server.payloads.fetchKeys.FetchKeysResDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.registration.RegistrationResDTO;
import com.billion_dollor_company.Bank_Server.payloads.transaction.TransactionReqDTO;
import com.billion_dollor_company.Bank_Server.payloads.transaction.TransactionResDTO;
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

    @Autowired
    public PSPController(PSPService pspService) {
        this.pspService = pspService;
    }

    /**
     * Retrieves basic account information for a user.
     *
     * @param request The account basic DTO.
     * @param errors BindingResult for validation errors.
     * @return ResponseEntity with AccountBasicDTO.
     * @throws AccountBasicRequestException if validation fails.
     */
    @PostMapping("/accountInfo")
    public ResponseEntity<AccountBasicDTO> getUserInfo(@Valid @RequestBody AccountBasicDTO request, BindingResult errors) {

        final String FUNCTION_NAME = "getUserInfo()";

        if (errors.hasErrors())
            throw new AccountBasicRequestException(errors);

        logIncomingRequest(request, FUNCTION_NAME);

        AccountBasicDTO userInfo = pspService.getAccountInfo(request);
        logOutgoingResponse(userInfo, FUNCTION_NAME);

        return ResponseEntity.ok(userInfo);
    }

    /**
     * Checks the balance of a user's account.
     *
     * @param request The balance request DTO.
     * @param errors BindingResult for validation errors.
     * @return ResponseEntity with BalanceResDTO.
     * @throws AccountBasicRequestException if validation fails.
     */
    @PostMapping("/checkBalance")
    public ResponseEntity<BalanceResDTO> getAccountBalance(@Valid @RequestBody BalanceReqDTO request, BindingResult errors) {

        final String FUNCTION_NAME = "getAccountBalance()";

        if (errors.hasErrors())
            throw new AccountBasicRequestException(errors);

        logIncomingRequest(request, FUNCTION_NAME);

        BalanceResDTO responseInfo = pspService.getAccountBalance(request);

        logOutgoingResponse(responseInfo, FUNCTION_NAME);

        if (responseInfo.getStatus().equals(Constants.Status.FAILED)) {
            return ResponseEntity.badRequest().body(responseInfo);
        }
        return ResponseEntity.ok().body(responseInfo);
    }

    /**
     * Initiates a transaction between accounts.
     *
     * @param request The transaction request DTO.
     * @param errors BindingResult for validation errors.
     * @return ResponseEntity with TransactionResDTO.
     * @throws TransactionRequestException if validation fails.
     */
    @PostMapping("/transaction")
    public ResponseEntity<TransactionResDTO> initiateTransaction(@Valid @RequestBody TransactionReqDTO request, BindingResult errors) {

        final String FUNCTION_NAME = "initiateTransaction()";

        if (errors.hasErrors())
            throw new TransactionRequestException(errors);

        logIncomingRequest(request, FUNCTION_NAME);

        TransactionResDTO responseInfo = pspService.initiateTransaction(request);

        logOutgoingResponse(responseInfo, FUNCTION_NAME);

        if (responseInfo.getStatus().equals(Constants.Status.FAILED)) {
            return ResponseEntity.badRequest().body(responseInfo);
        }

        return ResponseEntity.ok().body(responseInfo);
    }

    /**
     * Registers a new user account.
     *
     * @param request The registration request DTO.
     * @param errors BindingResult for validation errors.
     * @return ResponseEntity with RegistrationResDTO.
     * @throws RegistrationRequestException if validation fails.
     */
    @PostMapping("/registration")
    public ResponseEntity<RegistrationResDTO> register(@Valid @RequestBody RegistrationReqDTO request, BindingResult errors) {

        final String FUNCTION_NAME = "register()";

        if (errors.hasErrors()) {
            throw new RegistrationRequestException(errors);
        }

        logIncomingRequest(request, FUNCTION_NAME);

        RegistrationResDTO response = pspService.register(request);

        logOutgoingResponse(response, FUNCTION_NAME);

        if (response.getStatus().equals(Constants.Status.FAILED)) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    /**
     * Fetches cryptographic keys.
     *
     * @return ResponseEntity with FetchKeysResDTO.
     */
    @GetMapping("/fetchKeys")
    public ResponseEntity<FetchKeysResDTO> fetchKeys() {

        final String FUNCTION_NAME = "fetchKeys()";

        FetchKeysResDTO response = pspService.fetchKeys();

        logOutgoingResponse(response, FUNCTION_NAME);

        if (response.getStatus().equals(Constants.Status.FAILED)) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }


    /**
     * Logs the incoming request.
     *
     * @param reqObject The request object.
     * @param functionName The function name.
     */
    private void logIncomingRequest(Object reqObject, String functionName) {
        log.debug("Request is for: {}", functionName);
        log.debug("The request object is: {}", reqObject);
    }

    /**
     * Logs the outgoing response.
     *
     * @param resObject The response object.
     * @param functionName The function name.
     */
    private void logOutgoingResponse(Object resObject, String functionName) {
        log.debug("Response is for: {}", functionName);
        log.debug("The response object is: {}", resObject);
    }

}
