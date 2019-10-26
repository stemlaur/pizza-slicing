package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Instrumentation;

public final class MockLogInstrumentation implements Instrumentation {
    @Override
    public void startExploringThePizza() {
        System.out.println("Start exploring the pizza");
    }

    @Override
    public void numberOfSlicesFound(final NumberOfSlicesFound numberOfSlicesFound) {
        System.out.println("Max slices found " + numberOfSlicesFound);
    }
}
