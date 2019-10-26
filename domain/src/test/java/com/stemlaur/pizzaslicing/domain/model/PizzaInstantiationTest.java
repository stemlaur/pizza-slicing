package com.stemlaur.pizzaslicing.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PizzaInstantiationTest {

    @Test
    public void should_set_with_correct_size() {
        final char[][] cells = {{'M', 'M'}, {'M', 'M'},};
        final Pizza pizza = new Pizza(cells);
        assertEquals(2, pizza.height());
        assertEquals(2, pizza.width());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void should_not_work_with_no_cells() {
        final char[][] cells = {};
        new Pizza(cells);
    }

    @Test
    public void should_initialize_no_holes() {
        final char[][] cells = {{'T', 'T'}, {'T', 'T'},};
        final Pizza pizza = new Pizza(cells);

        assertEquals(Holes.noHoles(2, 2), pizza.holes());
    }
}
