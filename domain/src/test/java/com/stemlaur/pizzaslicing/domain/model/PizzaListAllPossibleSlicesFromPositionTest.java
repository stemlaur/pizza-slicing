package com.stemlaur.pizzaslicing.domain.model;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PizzaListAllPossibleSlicesFromPositionTest {

    @Test
    public void should_return_one_slice_when_there_is_only_one_cell_and_it_is_available() {
        final char[][] cells = {{'M'},};
        final boolean[][] oneHoleAtFirstCell = {{false}};
        final Pizza pizza = new Pizza(cells, new Holes(oneHoleAtFirstCell));
        final Set<Slice> slices = pizza.listAllPossibleSlicesFromPosition(new Position(0, 0));
        assertEquals(Collections.singleton(new Slice(cells, 0, 0, 0, 0)), slices);
    }

    @Test
    public void should_return_one_slices_when_there_are_two_cells_but_only_one_is_available() {
        final char[][] cells = {{'M', 'T'},};
        final boolean[][] oneHoleAtLastCell = {{false, true}};
        final Pizza pizza = new Pizza(cells, new Holes(oneHoleAtLastCell));
        final Set<Slice> slices = pizza.listAllPossibleSlicesFromPosition(new Position(0, 0));
        assertEquals(Collections.singleton(new Slice(cells, 0, 0, 0, 0)), slices);
    }

}