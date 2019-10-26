package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Slice;
import com.stemlaur.pizzaslicing.domain.shared.spec.Specification;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import static com.stemlaur.pizzaslicing.domain.model.Ingredients.MUSHROOM;
import static com.stemlaur.pizzaslicing.domain.model.Ingredients.TOMATO;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class SliceSpecificationFactory {
    public static Specification<Slice> businessRules(final int numberOfTomatoes,
                                                     final int numberOfMushrooms,
                                                     final int maxNumberOfCells) {
        return new ShouldContainAtLeastNCellOfGivenIngredient(TOMATO, numberOfTomatoes)
                .and(new ShouldContainAtLeastNCellOfGivenIngredient(MUSHROOM, numberOfMushrooms)
                        .and(new ShouldContainAtMostNCells(maxNumberOfCells)));
    }
}
