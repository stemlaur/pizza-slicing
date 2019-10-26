package com.stemlaur.pizzaslicing.domain.model;

import com.stemlaur.pizzaslicing.domain.shared.Immutable;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;

/**
 * x, y coordinates are respectively the horizontal and vertical addresses of any cell on a pizza.
 */
@EqualsAndHashCode
@Immutable
public final class Position {
    private final int x;
    private final int y;

    Position(final int x, final int y) {
        Validate.isTrue(x >= 0);
        Validate.isTrue(y >= 0);
        this.x = x;
        this.y = y;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }
}
