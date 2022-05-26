package com.example.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class AddressbookApplication {


    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(AddressbookApplication.class, args);
        log.info("AddressBook App Started in {} Environment",
                context.getEnvironment().getProperty("environment"));
        log.info("AddressBook App DB User is {}",
                context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
