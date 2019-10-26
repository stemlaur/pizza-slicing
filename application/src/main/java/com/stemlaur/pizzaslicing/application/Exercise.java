package com.stemlaur.pizzaslicing.application;

import com.stemlaur.pizzaslicing.domain.service.SearchMaximumNumberOfSlices;
import com.stemlaur.pizzaslicing.domain.service.NumberOfSlicesFound;

import java.io.IOException;

final class Exercise {
    private final RetrieveInput retrieveInput;
    private final SaveOuput saveOuput;

    Exercise(final RetrieveInput retrieveInput,
             final SaveOuput saveOuput) {
        this.retrieveInput = retrieveInput;
        this.saveOuput = saveOuput;
    }

    void resolve() throws IOException {
        final Input input = this.retrieveInput.ofFile();

        final NumberOfSlicesFound numberOfSlicesFound = new SearchMaximumNumberOfSlices(new LogInstrumentation(), input.getSpecification())
                .given(input.getPizza());
        if (numberOfSlicesFound.problemSatisfied()) {
            this.saveOuput.toFile(new Output(numberOfSlicesFound.slices()));
        } else {
            System.err.println("The given pizza cannot be completely sliced");
        }
    }
}
