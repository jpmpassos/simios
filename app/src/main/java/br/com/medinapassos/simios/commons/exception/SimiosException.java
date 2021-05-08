package br.com.medinapassos.simios.commons.exception;

import lombok.Getter;

public class SimiosException extends RuntimeException {
    @Getter
    private final ErrorDetails errorDetails;

    public SimiosException(final ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }
}
