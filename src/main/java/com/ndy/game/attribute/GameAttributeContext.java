package com.ndy.game.attribute;

import com.google.gson.annotations.Expose;
import com.ndy.game.attribute.exception.NullAttributeNameException;

import java.util.HashMap;
import java.util.Map;

public class GameAttributeContext {

    @Expose private Map<String, GameAttribute> attributeMap = new HashMap<>();

    public <V> void registerAttribute(String attributeName, GameAttribute<V> attribute) {
        attributeMap.put(attributeName, attribute);
    }

    public <V> GameAttribute<V> getAttribute(String attributeName) {
        GameAttribute<V> attribute = attributeMap.get(attributeName);

        if(attribute == null) throw new NullAttributeNameException(attributeName);

        return attribute;
    }

}
