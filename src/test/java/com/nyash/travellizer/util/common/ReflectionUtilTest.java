package com.nyash.travellizer.util.common;

import com.nyash.travellizer.common.infra.util.annotations.Ignore;

/**
 * Verifies functionality of the {@link ReflectionUtil} unit
 *
 * @author Nyash
 *
 */
public class ReflectionUtilTest {


}

class BaseSource {
    private int BaseField;
}

class BaseDestination {
    private int BaseField;
}

class Source extends BaseSource {
    private int value;

    private String text;

    @Ignore
    private int ignored = 2;

    private static int staticField;

    private final int finalfield = 0;

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
