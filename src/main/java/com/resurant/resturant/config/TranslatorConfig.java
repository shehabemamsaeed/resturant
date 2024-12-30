package com.resurant.resturant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class TranslatorConfig {
@Value("${spring.messages.basename}")
   private String message;
   @Value("${spring.messages.local-default}")
   private Locale localDefualt;

   @Bean("messages")
    public ResourceBundleMessageSource resourceBundleMessageSource(){
       ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
       resourceBundleMessageSource.setBasename(message);
       resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
       resourceBundleMessageSource.setDefaultEncoding("UTF-8");
       return  resourceBundleMessageSource;
   }
   @Bean
    public LocaleResolver localeResolver(){
       AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
       acceptHeaderLocaleResolver.setDefaultLocale(localDefualt);
       return acceptHeaderLocaleResolver;
   }



}

