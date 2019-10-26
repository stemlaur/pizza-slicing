package com.stemlaur.pizzaslicing.domain.model;

import com.stemlaur.pizzaslicing.domain.shared.Immutable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.util.stream.IntStream.range;

/**
 * A slice of pizza is a rectangular section of the pizza delimited by two rows and two columns.
 * This class decorates {@link Pizza } by adding the rectangular section and allowing to perform
 * various checks.
 */
@EqualsAndHashCode
@ToString(exclude = "cells")
@Immutable
public final class Slice {
    private final char[][] cells;
    private final int rowStart;
    private final int rowEnd;
    private final int columnStart;
    private final int columnEnd;

    public Slice(final char[][] cells,
                 final int rowStart,
                 final int rowEnd,
                 final int columnStart,
                 final int columnEnd) {
        this.cells = cells;
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
    }

    public int rowStart() {
        return this.rowStart;
    }

    public int rowEnd() {
        return this.rowEnd;
    }

    public int columnStart() {
        return this.columnStart;
    }

    public int columnEnd() {
        return this.columnEnd;
    }

    public int numberOfCells() {
        return (rowEnd - rowStart + 1) * (columnEnd - columnStart + 1);
    }

    public int numberOfCellsOf(final char givenIngredient) {
        return (int) range(rowStart, rowEnd + 1)
                .flatMap(row -> range(columnStart, columnEnd + 1).map(col -> cells[row][col]))
                .filter(value -> value == givenIngredient)
                .count();
    }
}
