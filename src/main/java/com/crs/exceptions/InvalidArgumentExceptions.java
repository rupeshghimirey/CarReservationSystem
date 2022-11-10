package com.crs.exceptions;

public class InvalidArgumentExceptions extends IllegalArgumentException {

    public InvalidArgumentExceptions() {
        super();
    }

    public InvalidArgumentExceptions(String s) {
        super(s);
    }

    public InvalidArgumentExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
