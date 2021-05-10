package br.com.medinapassos.simios.web.validation.commons;

import static br.com.medinapassos.simios.commons.exception.enums.SimiosExceptionEnum.DIVERGENT_DNA;
import static br.com.medinapassos.simios.commons.exception.enums.SimiosExceptionEnum.DIVERGENT_DNA_SIZE_LENGTH;
import static br.com.medinapassos.simios.commons.exception.factory.SimiosExceptionFactory.throwException;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class SimiosValidateCommons {

    protected SimiosValidateCommons() {
        throw new IllegalStateException("Classe utilitária, use apenas os métodos estáticos");
    }

    private static final String DNA_STR = "ATCG";

    public static void validateDNA(final String value) {
        final var arrayStr = value.toCharArray();
        for (int i = 0; i < arrayStr.length; i++) {
            if (!containsIgnoreCase(DNA_STR, String.valueOf(arrayStr[i]))) {
                throwException(DIVERGENT_DNA);
            }
        }
    }

    public static void validateLengthSize(final int size, final String dna) {
        if (size != dna.length()) {
            throwException(DIVERGENT_DNA_SIZE_LENGTH);
        }
    }
}
