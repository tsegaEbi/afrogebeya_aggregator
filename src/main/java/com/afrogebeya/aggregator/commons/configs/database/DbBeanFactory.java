package com.afrogebeya.aggregator.commons.configs.database;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datasource")
@Data
public class DbBeanFactory {
    String ddlAuto;
    String url;
    String username;
    String password;
    String driver;
}
