package com.stemlaur.pizzaslicing.application;

import com.stemlaur.pizzaslicing.domain.model.Pizza;
import com.stemlaur.pizzaslicing.domain.service.SliceSpecificationFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExerciseTest {
    @InjectMocks
    public Exercise exercise;
    @Mock
    public RetrieveInput retrieveInput;
    @Mock
    public SaveOuput saveOuput;

    @Test
    public void should_save_file() throws IOException {
        final char[][] cells = {"MT".toCharArray()};
        when(retrieveInput.ofFile()).thenReturn(new Input(
                new Pizza(cells),
                SliceSpecificationFactory.businessRules(1, 1, 2)
        ));
        exercise.resolve();
        verify(saveOuput).toFile(any());
    }

}