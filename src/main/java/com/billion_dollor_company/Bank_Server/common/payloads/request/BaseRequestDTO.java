package com.billion_dollor_company.Bank_Server.common.payloads.request;

import lombok.Getter;

@Getter
public class BaseRequestDTO<T> {

    private RequestHeader header;

    private T body;

    private Security security;

}
