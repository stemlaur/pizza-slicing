package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Position;
import com.stemlaur.pizzaslicing.domain.model.Instrumentation;
import com.stemlaur.pizzaslicing.domain.model.Pizza;
import com.stemlaur.pizzaslicing.domain.model.Slice;
import com.stemlaur.pizzaslicing.domain.shared.spec.Specification;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The domain service is responsible of searching the maximum number of {@link Slice}s
 * which can be sliced-out from a given pizza given constraints.
 * <p>
 * It uses greedy backtracking [A* search algorithm] to solve problem.
 */
public final class SearchMaximumNumberOfSlices {
    private final Instrumentation instrumentation;
    private final Specification<Slice> specification;

    public SearchMaximumNumberOfSlices(final Instrumentation instrumentation,
                                       final Specification<Slice> specification) {
        this.instrumentation = instrumentation;
        this.specification = specification;
    }

    public NumberOfSlicesFound given(final Pizza pizza) {
        this.instrumentation.startExploringThePizza();
        final NumberOfSlicesFound numberOfSlicesFound = recursivelySearchAllEligibleSlicesFor(pizza);
        this.instrumentation.numberOfSlicesFound(numberOfSlicesFound);
        return numberOfSlicesFound;
    }

    private NumberOfSlicesFound recursivelySearchAllEligibleSlicesFor(final Pizza pizza) {
        if (!pizza.holes().isThereAnyCellAvailable()) {
            return NumberOfSlicesFound.SATISFIED;
        } else {
            final Position firstAvailablePosition = pizza.holes().findFirstAvailableCell();
            final Set<Slice> slices = getEligibleSlices(pizza, firstAvailablePosition);
            if (slices.size() == 0) {
                return NumberOfSlicesFound.UNSATISFIED;
            }
            final List<NumberOfSlicesFound> allNumberOfSlicesFound = new ArrayList<>();
            for (Slice slice : slices) {
                final Pizza smallerPizza = pizza.cut(slice);
                final NumberOfSlicesFound numberOfSlicesFound =
                        recursivelySearchAllEligibleSlicesFor(smallerPizza)
                                .addSlice(slice);
                if (numberOfSlicesFound.problemSatisfied()) {
                    allNumberOfSlicesFound.add(numberOfSlicesFound);
                }
            }

            final Optional<NumberOfSlicesFound> max = allNumberOfSlicesFound.stream().max(Comparator.comparingInt(o -> o.slices().size()));
            return max.orElse(NumberOfSlicesFound.UNSATISFIED);
        }
    }

    private Set<Slice> getEligibleSlices(final Pizza pizza, final Position position) {
        return pizza.listAllPossibleSlicesFromPosition(position)
                .stream()
                .filter(this.specification::isSatisfiedBy)
                .filter(slice -> !pizza.holes().isThereAnyHole(slice.rowStart(), slice.rowEnd(), slice.columnStart(), slice.columnEnd()))
                .collect(Collectors.toSet());
    }

}
