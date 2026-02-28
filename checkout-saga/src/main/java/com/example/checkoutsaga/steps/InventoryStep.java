package com.example.checkoutsaga.steps;

import com.example.checkoutsaga.saga.SagaStep;
import org.springframework.stereotype.Component;

@Component
public class InventoryStep implements SagaStep {

    @Override
    public void execute() {
        System.out.println("Inventory: reserving items...");
        // throw new RuntimeException("Inventory failed!");
        System.out.println("Inventory: success");
    }

    @Override
    public void compensate() {
        System.out.println("Inventory: compensating - releasing reserved items...");
    }
}
