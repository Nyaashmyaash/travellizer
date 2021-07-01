package com.nyash.travellizer.common.model.transform.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This thread-safe class caches field names for each transformation pair
 *
 * @author Nyash
 */
public class CachedFieldProvider extends FieldProvider {

    /**
     * Mapping between transformation pair(class names) and field list
     */
    private final Map<String, List<String>> cache;

    private final Map<String, List<String>> domainFields;

    public CachedFieldProvider() {
        cache = new ConcurrentHashMap<>();
        domainFields = new ConcurrentHashMap<>();
    }
}
