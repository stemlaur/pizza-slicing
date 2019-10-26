package com.stemlaur.pizzaslicing.application;

import com.stemlaur.pizzaslicing.domain.model.Slice;
import lombok.Getter;

import java.util.Set;

@Getter
final class Output {
    private final int numberOfSlices;
    private final Set<Slice> slices;

    Output(final Set<Slice> slices) {
        this.slices = slices;
        this.numberOfSlices = slices.size();
    }
}
