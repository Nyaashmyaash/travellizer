package com.nyash.travellizer.common.model.transform.mapper;

public class StandardMapper implements Mapper<Object, Object>{
    @Override
    public boolean supports(Class<Object> sourceType, Class<Object> destinationType) {
        return sourceType.equals(destinationType);
    }

    @Override
    public Object map(Object sourceValue, Class<Object> destinationType) {
        return sourceValue;
    }
}
