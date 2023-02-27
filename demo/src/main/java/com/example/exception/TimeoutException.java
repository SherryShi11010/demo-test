package com.example.exception;

public class TimeoutException extends RuntimeException{
    public TimeoutException(String msg, Throwable t) {
        super(msg, t);
    }

    public TimeoutException(Throwable t) {
        super(t);
    }

    public TimeoutException(String msg) {
        super(msg);
    }

    public TimeoutException() {
    }
}
