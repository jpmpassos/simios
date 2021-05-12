package br.com.medinapassos.simios.web.validation.commons;

import br.com.medinapassos.simios.commons.exception.SimiosException;
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
        SimiosValidateCommons.validateDNA("ATTCAG");
    }

    @Test
    void validateLengthSize() {
        SimiosValidateCommons.validateLengthSize(6, "ACCCTG");
    }

    @Test
    void validateDNAError() {
        Assertions.assertThrows(SimiosException.class, () -> {
            SimiosValidateCommons.validateDNA("ATTCAw");
        });
    }

    @Test
    void validateLengthSizeError() {
        Assertions.assertThrows(SimiosException.class, () -> {
            SimiosValidateCommons.validateLengthSize(7, "ACCCTG");
        });
    }


}