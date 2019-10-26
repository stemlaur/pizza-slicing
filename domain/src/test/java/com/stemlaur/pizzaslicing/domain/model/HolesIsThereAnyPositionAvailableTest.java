package com.stemlaur.pizzaslicing.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HolesIsThereAnyPositionAvailableTest {

    @Test
    public void should_return_true_when_a_cell_is_available() {
        final boolean[][] oneHoleAtFirstCell = {{true, false}, {false, false}};
        final Holes holes = new Holes(oneHoleAtFirstCell);
        assertTrue(holes.isThereAnyCellAvailable());
    }

    @Test
    public void should_return_false_when_no_cell_is_available() {
        final boolean[][] oneHoleAtFirstCell = {{true, true}, {true, true}};
        final Holes holes = new Holes(oneHoleAtFirstCell);
        assertFalse(holes.isThereAnyCellAvailable());
    }
}
