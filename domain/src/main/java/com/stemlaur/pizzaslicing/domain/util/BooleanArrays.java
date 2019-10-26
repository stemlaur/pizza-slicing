package com.stemlaur.pizzaslicing.domain.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BooleanArrays {
    public static boolean[][] cloneArray(final boolean[][] src) {
        int length = src.length;
        boolean[][] target = new boolean[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }
}
