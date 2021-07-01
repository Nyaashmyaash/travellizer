package com.nyash.travellizer.util.common;

import com.nyash.travellizer.common.infra.exception.ConfigurationException;
import com.nyash.travellizer.common.infra.exception.flow.InvalidParameterException;
import com.nyash.travellizer.common.infra.util.ReflectionUtil;
import com.nyash.travellizer.common.infra.util.annotations.Ignore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.lang.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Verifies functionality of the {@link ReflectionUtil} unit
 *
 * @author Nyash
 */
public class ReflectionUtilTest {

//    @Test
//    void createInstanceSuccess() {
//        Object value = ReflectionUtil.createInstance(Source.class);
//        assertNotNull(value);
//    }

    @Test
    void testCreateInstanceFailure() {
        assertThrows(ConfigurationException.class, () -> ReflectionUtil.createInstance(Restricted.class));
    }

    @Test
    void testFindSimilarFieldsSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertNotNull(fields);
        assertTrue(fields.contains("value"));
    }

    @Test
    void testCopyFieldsSuccess() {
        Source src = new Source();
        src.setValue(10);
        Destination dest = new Destination();
        List<String> fields = ReflectionUtil.findSimilarFields(src.getClass(), dest.getClass());

        ReflectionUtil.copyFields(src, dest, fields);
        assertEquals(dest.getValue(), 10);
    }

    @Test
    void copyFindSimilarFieldsWithIgnoreSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertFalse(fields.contains("ignored"));
    }

    @Test
    void copyFindSimilarFieldsForStaticAndFinalSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertFalse(fields.contains("staticField"));
        assertFalse(fields.contains("finalField"));
    }

    @Test
    void copyFindSimilarFieldsForBaseFieldSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertTrue(fields.contains("baseField"));
    }

    @Test
    void copyFieldsDestinationNullFailure() {
        Source src = new Source();
        assertThrows(InvalidParameterException.class,
                () -> ReflectionUtil.copyFields(src, null, Collections.emptyList()));
    }

    @Test
    void getFieldsWithFilters_IgnoreFilter_1fieldReturned() {
        List<String> fields = ReflectionUtil.getFields(Source.class,
                List.of(field -> field.isAnnotationPresent(Ignore.class)));
        assertEquals(1, fields.size());
    }

    @Test
    void getFieldsWithFilters_NoFilters_allFieldsReturned() {
        List<String> fields = ReflectionUtil.getFields(Source.class, List.of());
        assertEquals(6,fields.size());
    }

    @Test
    void getFieldValue_validFieldName_valueReturned() {
        Source source = new Source();
        int value = (int) ReflectionUtil.getFieldValue(source, "ignored");
        assertEquals(2, value);
    }

    @Test
    void getFieldValue_invalidFieldName_exceptionThrown() {
        Source source = new Source();
        assertThrows(ConfigurationException.class, () -> ReflectionUtil.getFieldValue(source, "invalidname"));
    }

    @Test
    void setFieldValue_validFieldNameAndValue_valueChanged() {
        Source source = new Source();
        int newValue = 10;
        ReflectionUtil.setFieldValue(source, "ignored", newValue);
        int value = (int) ReflectionUtil.getFieldValue(source,"ignored");
        assertEquals(newValue, value);
    }
}

class BaseSource {
    private int baseField;
}

class BaseDestination {
    private int baseField;
}

class Source extends BaseSource {
    private int value;

    private String text;

    @Ignore
    private int ignored = 2;

    private static int staticField;

    private final int finalField = 0;

    public void setValue(int value) {
        this.value = value;
    }
}

class Destination extends BaseDestination {
    private int value;

    private int ignored;

    private int staticField;

    private int finalField = 0;

    public int getValue() {
        return value;
    }
}

class Restricted {
    public Restricted(int value) {

    }
}