package com.nyash.travellizer.util.common;

import com.nyash.travellizer.common.infra.util.ReflectionUtil;
import com.nyash.travellizer.common.infra.util.annotations.Ignore;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Verifies functionality of the {@link ReflectionUtil} unit
 *
 * @author Nyash
 *
 */
public class ReflectionUtilTest {

    @Test
    void createInstanceSuccess() {
        Object value = ReflectionUtil.createInstance(Source.class);
        assertNotNull(value);
    }

}

class BaseSource {
    private int BaseField;
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
