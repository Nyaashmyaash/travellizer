package com.nyash.travellizer.util.generator;

import com.nyash.travellizer.common.generator.text.RandomDigitStringGenerator;
import com.nyash.travellizer.common.generator.text.StringGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomDigitStringGeneratorTest {

    @Test
    void generate_size10_stringWith10DigitsGenerated() {
        int length = 10;
        StringGenerator generator = new RandomDigitStringGenerator(length);

        String text = generator.generate();

        assertEquals(text.length(), length);
        assertTrue(text.chars().allMatch(Character::isDigit));
    }
}