package com.sampleplugin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SamplePluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamplePluginApplication.class, args);
    }

    @Bean
    @ConditionalOnMissingBean(name = "adminController")
    public AdminController bookService() {
        return new AdminController();
    }


}
