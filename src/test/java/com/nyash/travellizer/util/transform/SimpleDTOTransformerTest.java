package com.nyash.travellizer.util.transform;

import com.nyash.travellizer.common.model.transform.Transformable;
import com.nyash.travellizer.common.model.transform.TransformableProvider;
import com.nyash.travellizer.common.model.transform.Transformer;
import com.nyash.travellizer.common.model.transform.impl.CachedFieldProvider;
import com.nyash.travellizer.common.model.transform.impl.SimpleDTOTransformer;
import com.nyash.travellizer.model.entity.base.AbstractEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer} unit
 *
 * @author Morenets
 */
public class SimpleDTOTransformerTest {
    private Transformer transformer;

    @BeforeEach
    public void setup() {
        transformer = new SimpleDTOTransformer(new CachedFieldProvider(), new StubTransformableProvider());
    }

    @Test
    void transform_fromSourceToDestination_success() {
        Source source = new Source();
        source.value = 10;
        source.text = "ab";
        source.day = DayOfWeek.FRIDAY;
        source.id = UUID.randomUUID();

        Destination destination = transformer.transform(source, Destination.class);
        assertNotNull(destination);
        assertEquals(source.value, destination.value);
    }

    public static class Source extends AbstractEntity {
        int value;

        String text;

        DayOfWeek day;

        UUID id;
    }

    public static class Destination {
        int value;

        String text;

        String day;

        String id;

    }

    private static class StubTransformableProvider implements TransformableProvider {

        @Override
        public <T, P> Optional<Transformable<T, P>> find(Class<T> classT) {
            return Optional.empty();
        }
    }

    private static class DestinationTransformable implements Transformable<Source, Destination> {
        @Override
        public Destination transform(Source source, Destination dest) {
            dest.text = "changed";
            return dest;
        }
    }

    private static class CustomTransformableProvider implements TransformableProvider {

        private final DestinationTransformable transformable = new DestinationTransformable();

        @Override
        public <T, P> Optional<Transformable<T, P>> find(Class<T> classT) {
            if (classT == Source.class) {
                return (Optional) Optional.of(transformable);
            }
            return Optional.empty();
        }
    }
}