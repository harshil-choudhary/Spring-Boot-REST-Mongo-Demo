package com.harshil.springbootrestmongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootRestMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestMongoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Address address = new Address(
                    "India",
                    "Test",
                    "test"
            );
            Student student = new Student(
                    "Harshil",
                    "Choudhary",
                    "bruhmoment@bruh.com",
                    Gender.MALE,
                    address,
                    List.of("Computer Science", "Math"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            repository.insert(student);
        };
    }
}
