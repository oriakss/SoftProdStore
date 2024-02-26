package com.softprod.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import static com.softprod.store.utils.Constants.CLASSPATH_MESSAGE;
import static java.nio.charset.StandardCharsets.UTF_8;


@Configuration
public class ApplicationConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(CLASSPATH_MESSAGE);
        messageSource.setDefaultEncoding(UTF_8.name());
        return messageSource;
    }
}