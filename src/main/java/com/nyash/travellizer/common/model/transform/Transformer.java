package com.nyash.travellizer.common.model.transform;

import com.nyash.travellizer.common.infra.util.Checks;
import com.nyash.travellizer.common.infra.util.ReflectionUtil;

import java.util.List;

/**
 * Represents transformation engine to convert business entities into DTO
 * objects
 *
 * @author Nyash
 *
 */
public interface Transformer {

    /**
     * Converts specified list of entities into destination class
     * @param <T>
     * @param <P>
     * @param entities
     * @param clz
     * @return
     */
    default <T,P> List<P> transform(List<T> entitiy, Class<P> clz) {
        checkParams(entitiy, clz);

        P dest = ReflectionUtil.createInstance(clz);

        return transform(entitiy, dest);
    }

    private void checkParams(final Object param, final Class<?> clz){
        checkParam(param, "Source transformation object is not initialized");
        checkParam(clz, "No class is defined for transformation");
    }

    private void checkParam(final Object param, final String errorMessage){
        Checks.checkParameter(param != null, errorMessage);
    }



}
