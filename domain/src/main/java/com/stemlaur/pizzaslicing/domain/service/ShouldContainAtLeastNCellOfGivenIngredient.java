package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Slice;
import com.stemlaur.pizzaslicing.domain.shared.spec.AbstractSpecification;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString
public final class ShouldContainAtLeastNCellOfGivenIngredient extends AbstractSpecification<Slice> {
    private final char givenIngredient;
    private final int minimumNumberOfCells;

    ShouldContainAtLeastNCellOfGivenIngredient(final char givenIngredient, final int minimumNumberOfCells) {
        this.givenIngredient = givenIngredient;
        this.minimumNumberOfCells = minimumNumberOfCells;
    }

    @Override
    public boolean isSatisfiedBy(final Slice slice) {
        return slice.numberOfCellsOf(givenIngredient) >= minimumNumberOfCells;
    }
}
