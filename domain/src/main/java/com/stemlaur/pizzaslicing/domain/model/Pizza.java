package com.stemlaur.pizzaslicing.domain.model;

import com.stemlaur.pizzaslicing.domain.shared.Immutable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A pizza is a rectangular, 2-dimensional grid of R rows and C columns.
 * A pizza contains cells of various coulors, which can be sliced-out.
 */
@ToString
@EqualsAndHashCode
@Immutable
public final class Pizza {
    private final char[][] cells;
    private final Holes holes;

    public Pizza(final char[][] cells) {
        this(cells, Holes.noHoles(cells.length, cells[0].length));
    }

    Pizza(final char[][] cells,
          final Holes holes) {
        this.cells = cells;
        this.holes = holes;
    }

    int height() {
        return this.cells.length;
    }

    int width() {
        return this.cells[0].length;
    }

    public Holes holes() {
        return this.holes;
    }

    public Set<Slice> listAllPossibleSlicesFromPosition(final Position position) {
        final int x = position.x();
        final int y = position.y();

        final Set<Slice> possibleSlices = new HashSet<>();
        for (int rowStart = x; rowStart < this.height(); rowStart++) {
            for (int rowEnd = rowStart; rowEnd < this.height(); rowEnd++) {
                for (int columnStart = y; columnStart < this.width(); columnStart++) {
                    for (int columnEnd = columnStart; columnEnd < this.width(); columnEnd++) {
                        if (!holes.isThereAnyHole(rowStart, rowEnd, columnStart, columnEnd)) {
                            possibleSlices.add(new Slice(cells, rowStart, rowEnd, columnStart, columnEnd));
                        }
                    }
                }
            }
        }
        return Collections.unmodifiableSet(possibleSlices);
    }

    public Pizza cut(final Slice slice) {
        return new Pizza(this.cells, holes.add(slice));
    }
}
