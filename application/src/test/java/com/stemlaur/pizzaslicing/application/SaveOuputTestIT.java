package com.stemlaur.pizzaslicing.application;

import com.stemlaur.pizzaslicing.domain.model.Slice;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SaveOuputTestIT {

    @Test
    public void toFile() throws IOException {
        final char[][] cells = {{'T', 'M'}};
        File outputFile = File.createTempFile("userlist", ".txt");
        final Set<Slice> slices = Collections.singleton(new Slice(cells, 0, 0, 0, 1));

        new SaveOuput(outputFile.getPath()).toFile(new Output(slices));

        final String expected = "1\n0 0 0 1\n";
        assertEquals(expected, FileUtils.readFileToString(outputFile, StandardCharsets.US_ASCII));
    }
}