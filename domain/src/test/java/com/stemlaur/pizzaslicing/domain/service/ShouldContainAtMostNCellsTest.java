package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Slice;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShouldContainAtMostNCellsTest {

    @Test
    public void should_be_satisfied() {
        final char[][] cells = {
                {'M', 'T', 'M'},
                {'T', 'M', 'M'},
                {'T', 'T', 'M'},
        };
        final Slice slice = new Slice(cells, 0, 0, 0, 2);
        final ShouldContainAtMostNCells spec = new ShouldContainAtMostNCells(9);
        assertTrue(spec.isSatisfiedBy(slice));
    }

    @Test
    public void should_not_be_satisfied() {
        final char[][] cells = {
                {'M', 'T', 'M'},
                {'T', 'M', 'M'},
                {'T', 'T', 'M'},
        };
        final Slice slice = new Slice(cells, 0, 0, 0, 2);
        final ShouldContainAtMostNCells spec = new ShouldContainAtMostNCells(1);
        assertFalse(spec.isSatisfiedBy(slice));
    }
}