package com.nyash.travellizer.common.model.entity;

/**
 * Loads and returns entity by entity class and identifier
 * @author Nyash
 *
 */
@FunctionalInterface
public interface EntityLoader {

    /**
     * Returns entity with specified identifier
     * @param clz
     * @param id
     * @return
     */
    <T extends AdstractEntity> T load(Class<T> clz, int id);

}
