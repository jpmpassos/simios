package br.com.medinapassos.simios.commons.exception.enums;

import br.com.medinapassos.simios.commons.exception.SimiosException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum SimiosExceptionEnum {
    DIVERGENT_DNA(SimiosException.class, "O DNA possui letras difernte de: 'A', 'T', 'C' e 'G'.", BAD_REQUEST),
    DIVERGENT_DNA_SIZE_LENGTH(SimiosException.class, "O DNA esta divergente a um matriz NxN.", BAD_REQUEST);
    private final Class<? extends Exception> type;
    private final String message;
    @Setter
    private HttpStatus httpStatus;

    SimiosExceptionEnum(final Class<? extends Exception> type, final String message, final HttpStatus httpStatus) {
        this.type = type;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
