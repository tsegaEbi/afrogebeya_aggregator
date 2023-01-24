package com.afrogebeya.aggregator.commons.configs.apis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "client")
@Data
public class ClientConfig {
    int id;
    String username;
    String password;
    String secret;
}
