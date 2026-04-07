package com.billion_dollor_company.Bank_Server.common.payload.request;

import lombok.Data;

@Data
public class BaseReqDTO<T extends RequestBody> {
    private Header header;
    private T body;
    private String signature;
}
