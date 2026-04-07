package com.billion_dollor_company.Bank_Server.common.payload.response;

import com.billion_dollor_company.Bank_Server.common.payload.request.RequestBody;
import lombok.Data;

@Data
public class BaseResDTO <T extends ResponseBody>{
    private String status;
    private String message;
    private String code;
    T body;
    private Meta meta;
}
