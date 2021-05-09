package br.com.medinapassos.simios.commons.exception.enums;

import br.com.medinapassos.simios.commons.exception.SimiosException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

import java.security.NoSuchAlgorithmException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
public enum SimiosExceptionEnum {
    DIVERGENT_DNA(SimiosException.class, "O DNA possui letras difernte de: 'A', 'T', 'C' e 'G'.", BAD_REQUEST),
    DIVERGENT_DNA_SIZE_LENGTH(SimiosException.class, "O DNA esta divergente a um matriz NxN.", BAD_REQUEST),
    ERROR_SQL_UNEXPECTED(SimiosException.class, "Erro inesperado na consulta SQL.", INTERNAL_SERVER_ERROR),
    UNIQUE_INDEX_SPECIES(DataIntegrityViolationException.class, "Já existe um DNA cadastrado na base de dados.", BAD_REQUEST),
    ERROR_INSTANCE_SHAR256(NoSuchAlgorithmException.class, "Erro ao instanciar MessageDigest.getInstance(\"SHA-256\").", INTERNAL_SERVER_ERROR);

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
