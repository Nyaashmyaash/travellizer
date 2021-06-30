package com.nyash.travellizer.util.generator;

import com.nyash.travellizer.common.generator.NumberGenerator;
import com.nyash.travellizer.common.generator.RandomNumberGenerator;
import com.nyash.travellizer.common.generator.SequentialNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberGeneratorTest {
    @Test
    void generate_limit9_numbersDontExceedTheLimit() {
        NumberGenerator numberGenerator = new RandomNumberGenerator(9);

        IntStream.range(0, 1000).map(i -> numberGenerator.generate()).filter(i -> i > 9)
                .forEach(i -> fail("Generated number " + i + " exceeds limit 9"));
    }

    @Test
    void generate_limit9_numbersAreRandomAndDistributionDoesntExceedDelta() {
        int limit = 20;
        int number = 1000;
        int delta = 3;
        NumberGenerator numberGenerator = new SequentialNumberGenerator(limit);

        Map<Integer, Long> results = IntStream.range(0, number).map(i -> numberGenerator.generate()).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        assertEquals(limit, results.size());
        int avg = number / limit;
        results.values().stream().filter(i -> Math.abs(i - avg) * 100 / avg > delta)
                .forEach(res -> fail("Random distribution fails with value " + res));
    }
}
