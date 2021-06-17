package com.nyash.travellizer.common.infra.exception.flow;

import com.nyash.travellizer.common.infra.exception.FlowException;

public class ReservationException extends FlowException {

    private static final long serialVersionUID = -4354969163379642678L;

    public ReservationException(String message) {
        super(message);
    }
}
