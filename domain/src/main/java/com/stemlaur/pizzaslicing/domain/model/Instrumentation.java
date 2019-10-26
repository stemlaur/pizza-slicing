package com.stemlaur.pizzaslicing.domain.model;

import com.stemlaur.pizzaslicing.domain.service.NumberOfSlicesFound;

/**
 * Domain probe interface aiming to hide logging (or possibly metrics) to the infrastructure layer.
 *
 * See https://martinfowler.com/articles/domain-oriented-observability.html
 */
public interface Instrumentation {

    void startExploringThePizza();

    void numberOfSlicesFound(NumberOfSlicesFound numberOfSlicesFound);
}
