# Checkout Saga Pattern

## Overview
This project implements the **Saga Pattern** with **Orchestration** approach
for an e-commerce checkout workflow using Spring Boot.
If any step fails, all previously completed steps are compensated in reverse order.

## Saga Type: Orchestration
A central orchestrator (`CheckoutSaga`) controls the order of steps and handles compensation.
This differs from Choreography, where each step would independently publish and listen to events.

## Workflow Steps
1. **Payment** - processes payment / refunds on failure
2. **Inventory** - reserves items / releases reservation on failure
3. **Shipping** - creates shipment / cancels shipment on failure

## How it works
Each step implements the `SagaStep` interface with two methods:
- `execute()` — performs the action
- `compensate()` — rolls back the action

If a step throws an exception, the orchestrator stops and compensates
all previously completed steps in reverse order.

## Simulating Failures
To simulate a failure, uncomment the `throw` line in any step:
```java
// throw new RuntimeException("Payment failed!");
```
Then re-run the application and observe compensation in the console.

## Project Structure
```
src/main/java/com/example/checkoutsaga/
├── saga/
│   ├── SagaStep.java         # Interface with execute() and compensate()
│   └── CheckoutSaga.java     # Central orchestrator
├── steps/
│   ├── PaymentStep.java
│   ├── InventoryStep.java
│   └── ShippingStep.java
└── CheckoutSagaApplication.java
```

## How to Run
```bash
mvn spring-boot:run
```