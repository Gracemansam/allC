package com.demoapp;

import org.laxture.spring.util.ApplicationContextProvider;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;


@SpringBootApplication
public class DemoAppApplication {

//    public static void main(String[] args) {
//        SpringApplicationBuilder builder = new SpringApplicationBuilder();
//       // builder.profiles("no_security");
//        builder.sources(DemoAppApplication.class);
//        builder.build().run();
//    }
public static void main(String[] args) {
    SpringApplication.run(DemoAppApplication.class, args);
}

    @Bean
    public ApplicationContextAware multiApplicationContextProviderRegister() {
        return ApplicationContextProvider::registerApplicationContext;
    }

    @Bean
    @ConditionalOnMissingBean
    @DependsOn("multiApplicationContextProviderRegister")
    public ModelMapper modelMapper() {
        //        mapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
//                .addValueReader(new RecordValueReader());
//        mapper.addConverter(new IdsConverter());
        return new ModelMapper();
    }
}
