package com.afrogebeya.aggregator.commons.configs.apis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
@Data
public class ApisConfig {
    String idsUrl;
    String idsSecret;
}
