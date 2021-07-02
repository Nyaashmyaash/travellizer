package com.nyash.travellizer.util.transform;

import com.nyash.travellizer.common.infra.util.ReflectionUtil;
import com.nyash.travellizer.common.model.transform.annotation.DomainProperty;
import com.nyash.travellizer.common.model.transform.impl.CachedFieldProvider;
import com.nyash.travellizer.common.model.transform.impl.FieldProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

    @Test
    void getDomainProperties_singleFieldAnnotation_oneFieldReturned() {
        List<String> fields = provider.getDomainProperties(DTO.class);
        assertNotNull(fields);
        assertEquals("id", fields.get(0));
    }

    @Test
    @Disabled
    void testGetFieldNamesAreCached() {
        List<String> fields = provider.getFieldNames(Source.class, Destination.class);

//        PowerMockito.mockStatic(ReflectionUtil.class);
        when(ReflectionUtil.findSimilarFields(Source.class, Destination.class)).thenReturn(Collections.emptyList());

        assertTrue(ReflectionUtil.findSimilarFields(Source.class, Destination.class).isEmpty());
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
