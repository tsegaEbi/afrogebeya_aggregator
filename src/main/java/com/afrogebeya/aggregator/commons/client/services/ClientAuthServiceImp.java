package com.afrogebeya.aggregator.commons.client.services;

import com.afrogebeya.profile.commons.client.models.ClientAuthRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientAuthServiceImp implements ClientAuthService{
    @Override
    public boolean validateClient(ClientAuthRequest request) {
        return false;
    }
}
