package com.nyash.travellizer.common.infra.exception.flow;

import com.nyash.travellizer.common.infra.exception.FlowException;

/**
 * {@link ValidationException} is raised when attribute values of the object
 * model violates business rules or restrictions
 *
 * @author Nyash
 *
 */
public class ValidationException extends FlowException {
    private static final long serialVersionUID = 6858621613562789296L;

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
