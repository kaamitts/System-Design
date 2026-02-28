package com.example.checkoutsaga.steps;

import com.example.checkoutsaga.saga.SagaStep;
import org.springframework.stereotype.Component;

@Component
public class PaymentStep implements SagaStep {

    @Override
    public void execute() {
        System.out.println("Payment: processing payment...");
//        throw new RuntimeException("Payment failed!");
        System.out.println("Payment: success");
    }

    @Override
    public void compensate() {
        System.out.println("Payment: compensating - refunding payment...");
    }
}