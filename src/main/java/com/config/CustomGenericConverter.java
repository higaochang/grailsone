package com.config;

import org.apache.commons.beanutils.BeanUtils;
import org.grails.config.NavigableMap;
import org.hibernate.criterion.AggregateProjection;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CustomGenericConverter implements GenericConverter {

    private final ConversionService conversionService;

    public CustomGenericConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {

        return Collections.singleton(new ConvertiblePair(org.grails.config.NavigableMap.class,
                Object.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        if (sourceType.isAssignableTo(targetType)) {
            return source;
        }
        NavigableMap map = (NavigableMap) source;

        if (map.size() == 0) {
            return null;
        }

        Map<String, Object> linkedHashMap = map.getDelegateMap();
        HashMap targetMap = new HashMap<>();
        for(Map.Entry e: linkedHashMap.entrySet()){
            targetMap.put(e.getKey(), e.getValue());
        }

//        Object firstElement = map.iterator().next();
//        return this.conversionService.convert(firstElement, sourceType.elementTypeDescriptor(firstElement), targetType);
        try {
            Object object = targetType.getType().newInstance();
//            BeanUtils.populate(object, targetMap);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
