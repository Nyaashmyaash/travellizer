package com.nyash.travellizer.common.model.transform.impl;

import com.nyash.travellizer.common.model.transform.Transformer;
import org.hibernate.loader.entity.EntityLoader;

/**
 * Transformer that is able to manage entity references when copying data
 * from/to DTO to entities
 *
 * @author Nyash
 *
 */
public class EntityReferenceTransformer implements Transformer {

    private final EntityLoader
    @Override
    public <T, P> P transform(T entity, P dest) {
        return null;
    }

    @Override
    public <T, P> T untransform(P dto, T entity) {
        return null;
    }
}
