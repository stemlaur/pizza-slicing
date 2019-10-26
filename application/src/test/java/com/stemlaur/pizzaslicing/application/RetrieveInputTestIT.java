package com.stemlaur.pizzaslicing.application;

import com.stemlaur.pizzaslicing.domain.model.Pizza;
import com.stemlaur.pizzaslicing.domain.service.SliceSpecificationFactory;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RetrieveInputTestIT {

    @Test
    public void should_retrieve_from_file() throws IOException {
        final char[][] cells = {"MMMMM".toCharArray(), "MTTTM".toCharArray(), "MMMMM".toCharArray()};
        final Input expected = new Input(new Pizza(cells), SliceSpecificationFactory.businessRules(1, 1, 6));

        assertEquals(expected, new RetrieveInput("src/test/resources/test-actual.in").ofFile());
    }
}