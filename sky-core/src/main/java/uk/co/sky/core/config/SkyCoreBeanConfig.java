package uk.co.sky.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.sky.core.service.CatalogueService;
import uk.co.sky.core.service.CustomerLocationService;
import uk.co.sky.core.service.CustomerLocationStubService;

@Configuration
public class SkyCoreBeanConfig {

    @Bean
    public CustomerLocationService customerLocationService() {
        return new CustomerLocationStubService();
    }

    @Bean
    public CatalogueService catalogueService() {
        return new CatalogueService();
    }
}
