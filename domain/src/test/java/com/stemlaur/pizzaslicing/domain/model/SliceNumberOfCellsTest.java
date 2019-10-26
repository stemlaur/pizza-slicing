package com.stemlaur.pizzaslicing.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SliceNumberOfCellsTest {
    @Test
    public void should_return_correct_number_of_total_cells() {
        final char[][] cells = {{'M'},};
        final Slice slice = new Slice(cells, 0, 0, 0, 0);
        assertEquals(1, slice.numberOfCells());
    }

    @Test
    public void should_return_correct_number_of_sub_cells() {
        final char[][] cells = {
                {'M', 'T'},
                {'T', 'M'},
        };
        final Slice slice = new Slice(cells, 0, 0, 0, 1);
        assertEquals(2, slice.numberOfCells());
    }

    @Test
    public void should_return_correct_number_of_cells_of_tomato() {
        final char[][] cells = {
                {'M', 'T'},
                {'T', 'M'},
        };
        final Slice slice = new Slice(cells, 0, 0, 0, 1);
        assertEquals(1, slice.numberOfCellsOf('T'));
    }

    @Test
    public void should_return_correct_number_of_sub_cells_of_tomato() {
        final char[][] cells = {
                {'M', 'T', 'M'},
                {'T', 'M', 'M'},
                {'T', 'T', 'M'},
        };
        final Slice slice = new Slice(cells, 1, 1, 0, 2);
        assertEquals(1, slice.numberOfCellsOf('T'));
    }
}
