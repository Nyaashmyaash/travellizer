package com.nyash.travellizer.util.generator;

import com.nyash.travellizer.common.generator.NumberGenerator;
import com.nyash.travellizer.common.generator.SequentialNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SequentialNumberGeneratorTest {

    @Test
    void generate_limit9_numbersDontExceedTheLimit() {
        NumberGenerator numberGenerator = new SequentialNumberGenerator(9);

        IntStream.range(0, 1000).map(i -> numberGenerator.generate()).filter(i -> i > 9)
                .forEach(i -> fail("Generated number " + i + " exceeds limit 9"));
    }

    @Test
    void generate_limit9_numbersAreSequential() {
        NumberGenerator numberGenerator = new SequentialNumberGenerator(5);

        int firstValue = numberGenerator.generate();
        assertEquals(numberGenerator.generate(), firstValue + 1);
    }
}
