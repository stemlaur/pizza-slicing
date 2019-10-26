package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Instrumentation;
import com.stemlaur.pizzaslicing.domain.model.Pizza;
import com.stemlaur.pizzaslicing.domain.model.Slice;
import com.stemlaur.pizzaslicing.domain.shared.spec.Specification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SearchMaximumNumberOfSlicesTest {

    private static final Specification<Slice> ONE_SLICE_AND_TWO_CELLS_MAX =
            SliceSpecificationFactory.businessRules(1, 1, 2);

    private static final Specification<Slice> ONE_SLICE_AND_SIX_CELLS_MAX =
            SliceSpecificationFactory.businessRules(1, 1, 6);

    private final Instrumentation instrumentation = new MockLogInstrumentation();

    @Test
    public void should_not_discover_any_slices_when_there_is_only_one_cell() {
        // arrange
        final Pizza pizza = new Pizza(new char[][]{{'T'}});
        // act
        final NumberOfSlicesFound numberOfSlicesFound =
                new SearchMaximumNumberOfSlices(instrumentation, ONE_SLICE_AND_TWO_CELLS_MAX).given(pizza);
        //assert
        final Set<Slice> expectedSlices = new HashSet<>();
        assertEquals(new NumberOfSlicesFound(false, expectedSlices), numberOfSlicesFound);
    }

    @Test
    public void should_discover_1_slice() {
        // arrange
        final char[][] cells = {
                {'T', 'M'}
        };
        final Pizza pizza = new Pizza(cells);
        // act
        final NumberOfSlicesFound numberOfSlicesFound = new SearchMaximumNumberOfSlices(instrumentation, ONE_SLICE_AND_TWO_CELLS_MAX).given(pizza);
        //assert
        final Set<Slice> expectedSlices = Collections.singleton(new Slice(cells, 0, 0, 0, 1));

        assertEquals(new NumberOfSlicesFound(true, expectedSlices), numberOfSlicesFound);
    }

    @Test
    public void should_discover_many_slices() {
        // arrange
        final char[][] cells = {
                "MMMMM".toCharArray(),
                "MTTTM".toCharArray(),
                "MMMMM".toCharArray(),
        };
        final Pizza pizza = new Pizza(cells);
        // act
        final NumberOfSlicesFound numberOfSlicesFound = new SearchMaximumNumberOfSlices(instrumentation, ONE_SLICE_AND_SIX_CELLS_MAX).given(pizza);
        //assert
        final Set<Slice> expectedSlices = Stream.of(
                new Slice(cells, 0, 2, 0, 1),
                new Slice(cells, 0, 2, 2, 2),
                new Slice(cells, 0, 2, 3, 4)
        ).collect(Collectors.toSet());

        assertEquals(new NumberOfSlicesFound(true, expectedSlices), numberOfSlicesFound);
    }
}
