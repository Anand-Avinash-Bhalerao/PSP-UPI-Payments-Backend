package com.billion_dollor_company.Bank_Server.common.payloads.response;

import com.billion_dollor_company.Bank_Server.psp.controller.payloads.CheckBalanceResBodyDTO;

public record BaseResponseDTO<T>(

        ResponseHeader header,

        T body,

        ErrorDetails error

) {
}
