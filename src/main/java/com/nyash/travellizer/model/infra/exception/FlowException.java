package com.nyash.travellizer.model.infra.exception;

import com.nyash.travellizer.model.infra.exception.base.AppException;

public class FlowException extends AppException {

    private static final long serialVersionUID = -2889607185988464072L;

    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlowException(String message) {
        super(message);
    }
}
