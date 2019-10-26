package com.stemlaur.pizzaslicing.application;

import com.stemlaur.pizzaslicing.domain.model.Slice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;

class SaveOuput {

    private final String filePath;

    SaveOuput(final String filePath) {
        this.filePath = filePath;
    }

    void toFile(final Output output) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(output.getNumberOfSlices()).append('\n');
        for (Slice slice : output.getSlices()) {
            builder.append(format("%d %d %d %d", slice.rowStart(), slice.columnStart(), slice.rowEnd(), slice.columnEnd())).append('\n');
        }
        Files.write(Paths.get(this.filePath), builder.toString().getBytes());
    }
}
