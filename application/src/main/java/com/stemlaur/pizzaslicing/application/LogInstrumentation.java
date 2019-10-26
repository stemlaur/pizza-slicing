package com.stemlaur.pizzaslicing.application;

import com.stemlaur.pizzaslicing.domain.model.Instrumentation;
import com.stemlaur.pizzaslicing.domain.service.NumberOfSlicesFound;

public final class LogInstrumentation implements Instrumentation {
    @Override
    public void startExploringThePizza() {
        System.out.println("Start exploring the pizza");
    }

    @Override
    public void numberOfSlicesFound(final NumberOfSlicesFound numberOfSlicesFound) {
        System.out.println("Max number of slices found " + numberOfSlicesFound);
    }
}
