package com.ndy.game.attribute;

import com.google.gson.annotations.Expose;

public class GameAttribute<V> {

    @Expose private V value;

    public GameAttribute(V value) {
        this.value = value;
    }

    public V getValue() { return value; }
    public void setValue(V value) { this.value = value; }
}
