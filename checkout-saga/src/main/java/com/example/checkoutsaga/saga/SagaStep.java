package com.example.checkoutsaga.saga;

public interface SagaStep {
    void execute();
    void compensate();
}