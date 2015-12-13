package org.mc.utils;

public class InvalidExpression extends RuntimeException {

    public InvalidExpression() {
    }

    public InvalidExpression(String message) {
        super(message);
    }

    public InvalidExpression(Throwable cause) {
        super(cause);
    }

    public InvalidExpression(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidExpression(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
