package uk.co.sky.rest.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.sky.core.service.CatalogueService;
import uk.co.sky.core.service.CustomerLocationService;
import uk.co.sky.rest.adapters.ChannelsAdapter;
import uk.co.sky.rest.adapters.CustomerLocationAdapter;
import uk.co.sky.rest.controller.CatalogueController;
import uk.co.sky.rest.controller.CustomerLocationController;

@Configuration
public class SkyRestBeanConfig {

    @Resource(name = "customerLocationService")
    private CustomerLocationService customerLocationService;

    @Resource(name = "catalogueService")
    private CatalogueService catalogueService;

    @Bean
    public CustomerLocationAdapter customerLocationAdpater() {
        return new CustomerLocationAdapter();
    }

    @Bean
    public ChannelsAdapter channelsAdapter() {
        return new ChannelsAdapter();
    }
    
    @Bean
    public CustomerLocationController customerLocationController() {
        return new CustomerLocationController(customerLocationService,
                customerLocationAdpater());
    }

    @Bean
    public CatalogueController catalogueController() {
        return new CatalogueController(catalogueService,
                channelsAdapter());
    }
}
