package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Slice;
import com.stemlaur.pizzaslicing.domain.shared.spec.AbstractSpecification;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString
public final class ShouldContainAtMostNCells extends AbstractSpecification<Slice> {
    private final int numberOfMaximumCells;

    ShouldContainAtMostNCells(final int numberOfMaximumCells) {
        this.numberOfMaximumCells = numberOfMaximumCells;
    }

    @Override
    public boolean isSatisfiedBy(final Slice slice) {
        return slice.numberOfCells() <= numberOfMaximumCells;
    }
}
