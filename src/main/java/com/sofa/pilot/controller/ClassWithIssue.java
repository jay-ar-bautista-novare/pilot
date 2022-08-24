package com.sofa.pilot.controller;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;

public class ClassWithIssue {

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolverUploadTest() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(104857600); // Sensitive (100MB)
        return multipartResolver;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(); // Sensitive, by default if maxUploadSize property is not defined, there is no limit and thus it's insecure
        return multipartResolver;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory(); // Sensitive, no limit by default
        return factory.createMultipartConfig();
    }

}
