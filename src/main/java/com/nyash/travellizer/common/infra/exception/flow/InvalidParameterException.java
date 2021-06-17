package com.nyash.travellizer.common.infra.exception.flow;


import com.nyash.travellizer.common.infra.exception.FlowException;

public class InvalidParameterException extends FlowException {

    private static final long serialVersionUID = 4990959228756992926L;

    public InvalidParameterException(String message) {
        super(message);
    }
}
