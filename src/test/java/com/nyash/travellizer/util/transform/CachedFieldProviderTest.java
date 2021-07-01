package com.nyash.travellizer.util.transform;

import com.nyash.travellizer.common.model.transform.annotation.DomainProperty;
import com.nyash.travellizer.common.model.transform.impl.CachedFieldProvider;
import com.nyash.travellizer.common.model.transform.impl.FieldProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Verifies functionality of the {@link CachedFieldProvider} unit
 *
 * @author Nyash
 */
public class CachedFieldProviderTest {
    private FieldProvider provider;

    @BeforeEach
    void setup() {
        provider = new CachedFieldProvider();
    }

    @Test
    void testGetFieldNamesSuccess() {
        List<String> fields = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(fields.isEmpty());
        assertTrue(fields.contains("value"));
    }

    @Test
    void testGetFieldNamesCachedSuccess() {
        List<String> fields = provider.getFieldNames(Source.class, Destination.class);
        List<String> fields2 = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(fields.isEmpty());
        assertEquals(fields, fields2);

    }

    class Source {
        int value;
    }

    class Destination {
        int value;
    }

    class DTO {
        @DomainProperty("id")
        private int id;
    }
}
