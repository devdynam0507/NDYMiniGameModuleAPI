package com.ndy.game.attribute.exception;

public class NullAttributeNameException extends RuntimeException {

    public NullAttributeNameException(String attributeName) {
        super("That attribute is an unregistered : " + attributeName );
    }
}
