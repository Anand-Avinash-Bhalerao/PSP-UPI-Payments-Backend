package com.billion_dollor_company.Bank_Server.cryptography.hashing.service;

public interface DatabasePWHashService {
    String getHashedPassword(String password);
}
