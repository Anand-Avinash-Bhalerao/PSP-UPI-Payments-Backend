package com.billion_dollor_company.Bank_Server.psp.controller.payloads;

import com.billion_dollor_company.Bank_Server.common.domain.Currency;

import java.math.BigDecimal;

public record CheckBalanceResBodyDTO(
        double availableBalance,
        Currency currency
) {
}