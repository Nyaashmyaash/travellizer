package com.nyash.travellizer.util.transform;

import com.nyash.travellizer.common.infra.exception.flow.InvalidParameterException;
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

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer} unit
 *
 * @author Nyash
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
        source.day = FRIDAY;
        source.id = UUID.randomUUID();

        Destination destination = transformer.transform(source, Destination.class);
        assertNotNull(destination);
        assertEquals(source.value, destination.value);
        assertEquals(source.text, destination.text);
        assertEquals(FRIDAY.name(), destination.day);
        assertEquals(source.id.toString(), destination.id);
    }

    @Test
    void transform_NullCity_exception() {
        assertThrows(InvalidParameterException.class, () -> transformer.transform(null, Destination.class));
    }

    @Test
    void testTransformNullDTOClassFailure() {
        assertThrows(InvalidParameterException.class,
                () -> transformer.transform(new Source(), (Class<Destination>) null));
    }

    @Test
    void untransform_fromSourceToDestination_success() {
        UUID id = UUID.randomUUID();
        Destination destination = new Destination();
        destination.value = 10;
        destination.text = "ab";
        destination.day = "MONDAY";
        destination.id = id.toString();

        Source source = transformer.untransform(destination, Source.class);
        assertNotNull(source);
        assertEquals(destination.value, source.value);
        assertEquals(destination.text, source.text);
        assertEquals(MONDAY, source.day);
        assertEquals(id, source.id);
    }

    @Test
    void untransform_nullDestination_exception() {
        assertThrows(InvalidParameterException.class, () -> transformer.untransform(null, Source.class));
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
