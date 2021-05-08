package br.com.medinapassos.simios.web.validation.commons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimiosValidateCommonsTest {

    @Test
    void testPrivateConstructor() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new SimiosValidateCommons();
        });
    }

    @Test
    void validateDNA() {
    }

    @Test
    void validateLengthSize() {
    }
}