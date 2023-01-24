package com.afrogebeya.aggregator.commons.client.services;

import com.afrogebeya.profile.commons.client.models.ClientAuthRequest;

public interface ClientAuthService {
    boolean validateClient(ClientAuthRequest request);
}
