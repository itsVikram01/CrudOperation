package org.crudtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@EntityScan
@ComponentScan
@SpringBootApplication
@EnableJpaRepositories
public class CrudTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudTaskApplication.class, args);
        System.out.println("Started!!!..........");
    }
}