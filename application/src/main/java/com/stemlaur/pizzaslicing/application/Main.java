package com.stemlaur.pizzaslicing.application;

import java.io.IOException;

public final class Main {

    public static void main(String[] args) throws IOException {
        new Exercise(
                new RetrieveInput("pizza.in"),
                new SaveOuput("slices.out")
        ).resolve();
    }
}
