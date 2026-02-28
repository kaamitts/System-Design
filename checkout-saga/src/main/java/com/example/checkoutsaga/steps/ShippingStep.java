package com.example.checkoutsaga.steps;

import com.example.checkoutsaga.saga.SagaStep;
import org.springframework.stereotype.Component;

@Component
public class ShippingStep implements SagaStep {

    @Override
    public void execute() {
        System.out.println("Shipping: creating shipment...");
         throw new RuntimeException("Shipping failed!");
//        System.out.println("Shipping: success");
    }

    @Override
    public void compensate() {
        System.out.println("Shipping: compensating - cancelling shipment...");
    }
}
