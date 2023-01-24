package com.afrogebeya.aggregator.commons.services.crypto;

public interface CryptoService {
    String encryptPassword(String password);
    String decryptHashedPassword(String hashedPassword);
}
