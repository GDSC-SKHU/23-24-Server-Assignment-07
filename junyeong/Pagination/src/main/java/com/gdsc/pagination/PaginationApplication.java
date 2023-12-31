package com.gdsc.pagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginationApplication.class, args);
    }

}
