package com.nyash.travellizer.common.model.transform.impl;

import com.nyash.travellizer.common.infra.cdi.Cached;
import com.nyash.travellizer.common.infra.cdi.DBSource;
import com.nyash.travellizer.common.infra.exception.ConfigurationException;
import com.nyash.travellizer.common.infra.util.ReflectionUtil;
import com.nyash.travellizer.common.model.entity.EntityLoader;
import com.nyash.travellizer.common.model.entity.base.AbstractEntity;
import com.nyash.travellizer.common.model.transform.TransformableProvider;
import com.nyash.travellizer.common.model.transform.Transformer;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Transformer that is able to manage entity references when copying data
 * from/to DTO to entities
 *
 * @author Nyash
 */
public class EntityReferenceTransformer implements Transformer {

    private final EntityLoader entityLoader;

    /**
     * Transformer object to delegate to continue working process
     */
    private final Transformer delegate;

    private final TransformableProvider transformableProvider;

    public EntityReferenceTransformer(@DBSource EntityLoader entityLoader, @Cached FieldProvider fieldProvider,
                                      TransformableProvider transformableProvider) {
        this.entityLoader = entityLoader;
        this.delegate = new SimpleDTOTransformer(fieldProvider, transformableProvider);
        this.transformableProvider = transformableProvider;
    }

    @Override
    public <T, P> P transform(T entity, P dest) {
        Class<T> clz = (Class<T>) entity.getClass();
        Map<String, String> mapping = transformableProvider.find(clz).map(t -> t.getSourceMapping()).orElse(Map.of());

        for (Entry<String,String> entry : mapping.entrySet()) {
            String name = entry.getKey();
            String domainProperty = entry.getValue();
            Object value = ReflectionUtil.getFieldValue(entity, domainProperty);
            if (!(value instanceof AbstractEntity)) {
                throw new ConfigurationException(
                        "Reference property value of the domain object " + entity + " is not an entity: " + value);
            }
            AbstractEntity ref = (AbstractEntity) value;
            int id = ref.getId();
            ReflectionUtil.setFieldValue(dest, name, id);
        }
        return delegate.transform(entity, dest);
    }

    @Override
    public <T, P> T untransform(P dto, T entity) {
        return null;
    }
}
