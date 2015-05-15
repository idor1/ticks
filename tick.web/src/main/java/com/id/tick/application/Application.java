package com.id.tick.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 */
@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan
@Controller(value = "tick")
public class Application extends SpringBootServletInitializer {

    //http://info.michael-simons.eu/2014/02/25/boot-your-application-with-spring-boot/

//    @Bean
//    public String home(
//            final @Value("longitude") String longitude,
//            final @Value("latitude") String latitude
////            final @Value("${biking2.home.longitude}") String longitude,
////            final @Value("${biking2.home.latitude}") String latitude
//    ) {
//        return longitude + " " + latitude;
//    }

//    @Bean
//    public String home2(
////            final @Value("${biking2.home.longitude}") String longitude,
////            final @Value("${biking2.home.latitude}") String latitude
//    ) {
//        return "home 2 hello";
//    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World tick!";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String... args) {
        System.setProperty("spring.profiles.default", System.getProperty("spring.profiles.default", "dev"));
        final ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }
}

