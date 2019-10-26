package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Slice;
import com.stemlaur.pizzaslicing.domain.shared.Immutable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the result of searching a Pizza in order to find the maximum number of slices.
 */
@ToString
@EqualsAndHashCode
@Immutable
public final class NumberOfSlicesFound {
    static final NumberOfSlicesFound SATISFIED = new NumberOfSlicesFound(true);
    static final NumberOfSlicesFound UNSATISFIED = new NumberOfSlicesFound(false);

    private final boolean problemSatisfied;
    private final Set<Slice> slices;

    private NumberOfSlicesFound(final boolean problemSatisfied) {
        this(problemSatisfied, new HashSet<>());
    }

    NumberOfSlicesFound(final boolean problemSatisfied, final Set<Slice> slices) {
        this.problemSatisfied = problemSatisfied;
        this.slices = slices;
    }

    NumberOfSlicesFound addSlice(final Slice sliceToAdd) {
        final Set<Slice> slicesCopy = new HashSet<>(this.slices);
        slicesCopy.add(sliceToAdd);
        return new NumberOfSlicesFound(this.problemSatisfied, slicesCopy);
    }

    public boolean problemSatisfied() {
        return this.problemSatisfied;
    }

    public Set<Slice> slices() {
        return this.slices;
    }
}
