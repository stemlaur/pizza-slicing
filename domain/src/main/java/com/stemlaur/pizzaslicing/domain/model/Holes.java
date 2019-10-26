package com.stemlaur.pizzaslicing.domain.model;

import com.stemlaur.pizzaslicing.domain.shared.Immutable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static com.stemlaur.pizzaslicing.domain.util.BooleanArrays.cloneArray;

@EqualsAndHashCode
@ToString
@Immutable
public final class Holes {
    private final boolean[][] holes;

    Holes(final boolean[][] holes) {
        this.holes = holes;
    }

    static Holes noHoles(final int height, final int width) {
        return new Holes(new boolean[height][width]);
    }

    /**
     * call @see #isThereAnyCellAvailable() before this one
     */
    public Position findFirstAvailableCell() {
        for (int row = 0; row < holes.length; row++) {
            for (int column = 0; column < holes[0].length; column++) {
                if (!holes[row][column]) {
                    return new Position(row, column);
                }
            }
        }
        throw new IllegalStateException("Please use #isThereAnyCellAvailable before using this method.");
    }

    public boolean isThereAnyCellAvailable() {
        for (final boolean[] hole : holes) {
            for (int column = 0; column < holes[0].length; column++) {
                if (!hole[column]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isThereAnyHole(final int rowStart, final int rowEnd, final int columnStart, final int columnEnd) {
        for (int row = rowStart; row <= rowEnd; row++) {
            for (int column = columnStart; column <= columnEnd; column++) {
                if (holes[row][column]) {
                    return true;
                }
            }
        }
        return false;
    }

    Holes add(final Slice slice) {
        final boolean[][] copy = cloneArray(holes);
        for (int row = slice.rowStart(); row <= slice.rowEnd(); row++) {
            for (int column = slice.columnStart(); column <= slice.columnEnd(); column++) {
                copy[row][column] = true;
            }

        }
        return new Holes(copy);
    }
}
