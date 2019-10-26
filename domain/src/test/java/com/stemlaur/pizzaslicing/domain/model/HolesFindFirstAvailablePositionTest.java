package com.stemlaur.pizzaslicing.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HolesFindFirstAvailablePositionTest {

    @Test
    public void should_return_cell_if_exists() {
        final boolean[][] oneHoleAtFirstCell = {{true, false}, {false, false}};
        final Position actual = new Holes(oneHoleAtFirstCell).findFirstAvailableCell();
        assertEquals(new Position(0, 1), actual);
    }

    @Test(expected = IllegalStateException.class)
    public void should_fail_when_there_is_no_cell_available() {
        final boolean[][] allHole = {{true, true}, {true, true}};
        new Holes(allHole).findFirstAvailableCell();
    }

}