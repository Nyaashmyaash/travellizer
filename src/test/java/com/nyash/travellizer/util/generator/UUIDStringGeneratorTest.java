package com.nyash.travellizer.util.generator;

import com.nyash.travellizer.common.generator.text.StringGenerator;
import com.nyash.travellizer.common.generator.text.UUIDStringGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UUIDStringGeneratorTest {

    @Test
    void generate_validUUIDGeneratedContainingOnlyHexCharacters() {
        int length = 36;
        StringGenerator generator = new UUIDStringGenerator();

        String text = generator.generate();

        assertEquals(length, text.length());
        assertEquals( length - 4, text.replace("-", "").chars()
                .map(ch -> Integer.parseInt(String.valueOf(ch), 16)).count());
    }
}
