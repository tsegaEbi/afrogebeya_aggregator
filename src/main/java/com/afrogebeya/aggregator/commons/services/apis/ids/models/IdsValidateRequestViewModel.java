package com.afrogebeya.aggregator.commons.services.apis.ids.models;

import lombok.Data;

@Data
public class IdsValidateRequestViewModel {
    int clientId;
    String clientSecret;
    String token;
}
