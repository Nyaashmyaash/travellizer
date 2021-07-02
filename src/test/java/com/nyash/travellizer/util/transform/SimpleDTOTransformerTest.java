package com.nyash.travellizer.util.transform;

import com.nyash.travellizer.common.model.transform.Transformable;
import com.nyash.travellizer.common.model.transform.TransformableProvider;
import com.nyash.travellizer.common.model.transform.Transformer;
import com.nyash.travellizer.common.model.transform.impl.CachedFieldProvider;
import com.nyash.travellizer.common.model.transform.impl.SimpleDTOTransformer;
import com.nyash.travellizer.model.entity.base.AbstractEntity;
import org.junit.jupiter.api.BeforeEach;

import java.time.DayOfWeek;
import java.util.Optional;
import java.util.UUID;

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
