package com.billion_dollor_company.Bank_Server.psp.mappers;

import com.billion_dollor_company.Bank_Server.domain.model.EncryptedData;
import com.billion_dollor_company.Bank_Server.psp.payloads.EncryptedReqDTO;
import com.billion_dollor_company.Bank_Server.psp.payloads.checkbalance.CheckBalanceResDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PSPMapper {
    EncryptedData mapEncryptedReqDtoToEncryptedData(EncryptedReqDTO encryptedDataDto);
}
