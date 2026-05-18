package com.billion_dollor_company.Bank_Server.psp.integration.npci;

import com.billion_dollor_company.Bank_Server.common.payloads.request.BaseRequestDTO;
import com.billion_dollor_company.Bank_Server.common.payloads.response.BaseResponseDTO;
import com.billion_dollor_company.Bank_Server.psp.domain.CheckBalanceCommand;
import com.billion_dollor_company.Bank_Server.psp.domain.CheckBalanceResult;
import com.billion_dollor_company.Bank_Server.psp.integration.npci.dto.checkBalance.NPCICheckBalanceReqBodyDTO;
import com.billion_dollor_company.Bank_Server.psp.integration.npci.dto.checkBalance.NPCICheckBalanceResBodyDTO;
import com.billion_dollor_company.Bank_Server.psp.integration.npci.mapper.NPCIMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NPCIHttpClient implements NPCIClient {

    @Autowired
    private NPCIMapper npciMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${npci.base-url}")
    private String baseUrl;

    @Value("${npci.endpoints.checkBalance}")
    private String checkBalanceEndpoint;


    @Override
    public CheckBalanceResult initiateCheckBalance(CheckBalanceCommand command) {

        final String url = baseUrl + checkBalanceEndpoint;

        // Map CheckBalanceCommand to NPCI request format
        BaseRequestDTO<NPCICheckBalanceReqBodyDTO> request = npciMapper.toNPCICheckBalanceReq(command);

        // make HTTP call to NPCI endpoint.
        BaseResponseDTO<NPCICheckBalanceResBodyDTO> response = restTemplate.postForObject("", request, BaseResponseDTO.class);

        return npciMapper.toCheckBalanceResult(response);
    }
}