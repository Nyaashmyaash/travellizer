package com.nyash.travellizer.util.transform;

import com.nyash.travellizer.common.model.transform.Transformer;
import com.nyash.travellizer.common.model.transform.impl.CachedFieldProvider;
import com.nyash.travellizer.common.model.transform.impl.SimpleDTOTransformer;
import com.nyash.travellizer.model.entity.base.AbstractEntity;
import org.junit.jupiter.api.BeforeEach;

import java.time.DayOfWeek;
import java.util.UUID;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer} unit
 *
 * @author Morenets
 *
 */
public class SimpleDTOTransformerTest {
    private Transformer transformer;

    @BeforeEach
    public void setup() {
        transformer = new SimpleDTOTransformer(new CachedFieldProvider(), new StubTransformableProvider());
    }

    public static class Source extends AbstractEntity {
        int value;

        String text;

        DayOfWeek day;

        UUID id;
    }
}
