package uk.co.sky.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import uk.co.sky.core.config.SkyCoreBeanConfig;
import uk.co.sky.rest.config.SkyRestBeanConfig;

@SpringBootApplication()
@Import({ SkyCoreBeanConfig.class, SkyRestBeanConfig.class })
public class SkyApp {
    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(SkyApp.class);
        application.setWebEnvironment(true);
        application.run(args);
    }
}
