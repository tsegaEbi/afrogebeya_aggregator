package com.afrogebeya.aggregator.commons.services.crypto;

import com.afrogebeya.profile.commons.configs.security.CryptoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CryptoServiceImp implements CryptoService{
    @Autowired
    CryptoConfig cryptoConfig;
    @Override
    public String encryptPassword(String password) {
        return password;
    }

    @Override
    public String decryptHashedPassword(String hashedPassword) {
        return hashedPassword;
    }
}
