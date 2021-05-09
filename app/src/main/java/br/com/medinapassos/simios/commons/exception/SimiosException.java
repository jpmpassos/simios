package br.com.medinapassos.simios.commons.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
public class SimiosException extends RuntimeException {
    @Getter
    private final ErrorDetails errorDetails;
}
