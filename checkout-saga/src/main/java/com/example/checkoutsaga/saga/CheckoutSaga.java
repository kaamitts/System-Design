package com.example.checkoutsaga.saga;

import com.example.checkoutsaga.steps.InventoryStep;
import com.example.checkoutsaga.steps.PaymentStep;
import com.example.checkoutsaga.steps.ShippingStep;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckoutSaga {

    private final List<SagaStep> executedSteps = new ArrayList<>();
    private final PaymentStep paymentStep;
    private final InventoryStep inventoryStep;
    private final ShippingStep shippingStep;

    public CheckoutSaga(PaymentStep paymentStep,
                        InventoryStep inventoryStep,
                        ShippingStep shippingStep) {
        this.paymentStep = paymentStep;
        this.inventoryStep = inventoryStep;
        this.shippingStep = shippingStep;
    }

    public void execute() {
        List<SagaStep> steps = List.of(paymentStep, inventoryStep, shippingStep);

        for (SagaStep step : steps) {
            try {
                step.execute();
                executedSteps.add(step);
            } catch (RuntimeException e) {
                System.out.println("Step failed: " + e.getMessage());
                compensate();
                return;
            }
        }
        System.out.println("Checkout completed successfully");
    }

    private void compensate() {
        System.out.println("Starting compensation...");
        for (int i = executedSteps.size() - 1; i >= 0; i--) {
            executedSteps.get(i).compensate();
        }
    }
}
