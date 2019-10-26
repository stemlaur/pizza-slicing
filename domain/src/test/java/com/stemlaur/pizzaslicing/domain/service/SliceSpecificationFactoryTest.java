package com.stemlaur.pizzaslicing.domain.service;

import com.stemlaur.pizzaslicing.domain.model.Slice;
import com.stemlaur.pizzaslicing.domain.shared.spec.Specification;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SliceSpecificationFactoryTest {

    @Test
    public void should_be_satistified() {
        final char[][] cells = {
                {'M', 'T', 'M'},
                {'T', 'M', 'M'},
                {'T', 'T', 'M'},
        };
        final Slice slice = new Slice(cells, 1, 1, 0, 2);

        final Specification<Slice> spec = SliceSpecificationFactory.businessRules(1, 1, 3);
        assertTrue(spec.isSatisfiedBy(slice));
    }

    @Test
    public void should_not_be_satistified() {
        final char[][] cells = {
                {'M', 'T', 'M'},
                {'T', 'M', 'M'},
                {'T', 'T', 'M'},
        };
        final Slice slice = new Slice(cells, 1, 1, 0, 2);

        final Specification<Slice> spec = SliceSpecificationFactory.businessRules(2, 1, 2);
        assertFalse(spec.isSatisfiedBy(slice));
    }
}