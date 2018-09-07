package com.spider.exception;

public class HttpIOException extends SystemException {

    public HttpIOException() {
    }

    public HttpIOException(String message) {
        super(message);
    }

    public HttpIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpIOException(Throwable cause) {
        super(cause);
    }

    public HttpIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
