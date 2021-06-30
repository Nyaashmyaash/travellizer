package com.nyash.travellizer.common.infra.util;

import com.nyash.travellizer.common.infra.exception.ConfigurationException;
import com.nyash.travellizer.common.infra.util.annotations.Ignore;
import com.nyash.travellizer.common.model.transform.mapper.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Contains reflection-related utility operations
 *
 * @author Nyash
 *
 */
public class ReflectionUtil {
    private static final List<Mapper> MAPPERS;

    static {
        MAPPERS = List.of(new EnumToStringMapper(), new StringToEnumMapper(),
                new StringToUuidMapper(), new UuidToStringMapper());
    }

    private ReflectionUtil(){
    }

    /**
     * Creates an instance of the specified class. This method throws unchecked
     * exception if creation fails
     *
     * @param clz
     * @return
     * @throws ConfigurationException
     */
    public static <T> T createInstance(Class<T> clz) throws ConfigurationException {
        try {
            return clz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ConfigurationException(e);
        }
    }

    /**
     * Returns list of fields with identical names irregardles of their modifiers
     *
     * @param clz1
     * @param clz2
     * @return
     */
    public static List<String> findSimilarFields(Class<?> clz1, Class<?> clz2) throws  ConfigurationException {
        try {
            Predicate<Field> ignoreAbsent = field -> !field.isAnnotationPresent(Ignore.class);
            List<String> targetFields = getFields(clz2, List.of(ignoreAbsent));

            return getFields(clz1, List.of(ignoreAbsent,
                    field -> !Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers()),
                    field -> targetFields.contains(field.getName())));
        } catch (SecurityException ex) {
            throw new ConfigurationException(ex);
        }
    }

    /***
     * Returns all declared fields of the specified classes and all superclasses
     *
     * @param cls
     * @return
     */
    public static <T> List<Field> getFields(final Class<?> cls) {
        List<Field> fields = new ArrayList<Field>();

        Class<?> current = cls;
        while (current != null) {
            fields.addAll(Arrays.asList(current.getDeclaredFields()));
            current = current.getSuperclass();
        }

        return fields;

    }

    /**
     * Returns list of the class fields that match specified criteria
     *
     * @param cls
     * @param filters
     * @return
     */
    public static List<String> getFields(final Class<?> cls, final List<Predicate<Field>> filters) {
        List<Field> fields = new ArrayList<Field>();

        Class<?> current = cls;
        while (current != null) {
            fields.addAll(Arrays.stream(current.getDeclaredFields())
                    .filter(field -> filters.stream().allMatch(p -> p.test(field))).collect(Collectors.toList()));
            current = current.getSuperclass();
        }

        return fields.stream().map(Field::getName).collect(Collectors.toList());
    }

    /**
     * Copy specified fields values from source to destination objects
     *
     * @param src
     * @param dest
     * @param fields
     */
}
