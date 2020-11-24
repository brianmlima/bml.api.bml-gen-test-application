package org.bml.bml.gen.test.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@EnableScheduling
@Log4j2
@ComponentScan(basePackages = {"org.bml"})
public final class Application {

    private Application() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void main(final String[] args) {
        log.info("Starting up identifier application...");
        SpringApplication.run(Application.class, args);
    }
}
