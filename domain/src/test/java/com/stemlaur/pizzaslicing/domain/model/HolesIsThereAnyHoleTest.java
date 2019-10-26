package com.stemlaur.pizzaslicing.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HolesIsThereAnyHoleTest {

    @Test
    public void should_return_true_when_area_contains_a_hole_at_first_position() {
        final boolean[][] oneHoleAtFirstCell = {{true, false}, {false, false}};
        assertTrue(new Holes(oneHoleAtFirstCell).isThereAnyHole(0, 0, 0, 0));
    }

    @Test
    public void should_return_true_when_area_contains_a_hole_at_last_position() {
        final boolean[][] oneHoleAtFirstCell = {{false, false}, {false, true}};
        assertTrue(new Holes(oneHoleAtFirstCell).isThereAnyHole(1, 1, 1, 1));
    }

    @Test
    public void should_return_true_when_area_contains_a_hole_in_part_of_an_area() {
        final boolean[][] oneHoleAtFirstCell = {{false, false}, {false, true}};
        assertTrue(new Holes(oneHoleAtFirstCell).isThereAnyHole(0, 1, 1, 1));
    }

    @Test
    public void should_return_false_when_area_contains_no_hole() {
        final boolean[][] oneHoleAtFirstCell = {{false, false}, {false, false}};
        assertFalse(new Holes(oneHoleAtFirstCell).isThereAnyHole(0, 1, 1, 1));
    }
}
