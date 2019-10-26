package com.stemlaur.pizzaslicing.application;


import com.stemlaur.pizzaslicing.domain.model.Pizza;
import com.stemlaur.pizzaslicing.domain.service.SliceSpecificationFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RetrieveInput {
    private final String filePath;

    RetrieveInput(final String filePath) {
        this.filePath = filePath;
    }

    Input ofFile() throws IOException {
        final List<String> lines = fromFileToListOfString(this.filePath);
        final int minNumberOfCellIngredient = extractMinNumberOfCellIngredient(lines);
        final int maxNumberOfCells = extractMaxNumberOfCells(lines);
        final Pizza pizza = extractPizza(lines);
        return new Input(
                pizza,
                SliceSpecificationFactory.businessRules(minNumberOfCellIngredient, minNumberOfCellIngredient, maxNumberOfCells)
        );
    }
    
    private Pizza extractPizza(final List<String> lines) {
        return new Pizza(lines.stream()
                .skip(1L)
                .map(String::toCharArray)
                .toArray(char[][]::new));
    }

    private int extractMinNumberOfCellIngredient(final List<String> lines) {
        return Integer.parseInt(lines.get(0).split(" ")[2]);
    }

    private int extractMaxNumberOfCells(final List<String> lines) {
        return Integer.parseInt(lines.get(0).split(" ")[3]);
    }

    private static List<String> fromFileToListOfString(final String filePath) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.US_ASCII)) {
            return stream.collect(Collectors.toList());
        }
    }
}
