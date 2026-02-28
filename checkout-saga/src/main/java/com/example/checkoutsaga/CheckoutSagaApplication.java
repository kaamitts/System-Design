package com.example.checkoutsaga;

import com.example.checkoutsaga.saga.CheckoutSaga;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CheckoutSagaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckoutSagaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CheckoutSaga checkoutSaga) {
        return args -> {
            System.out.println("=== Starting Checkout Saga ===");
            checkoutSaga.execute();
            System.out.println("=== Checkout Saga Finished ===");
        };
    }
}
