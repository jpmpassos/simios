package br.com.medinapassos.simios.persistense.commons;

import br.com.medinapassos.simios.test.Mocks;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessStatsCommonTest {

    @Test
    void process() {
        final var result = ProcessStatsCommon.process(Mocks.getObjtcs());
        assertEquals(result.orElseThrow().getCountHumanDna(), BigInteger.ONE);
        assertEquals(result.orElseThrow().getCountSimianDna(), BigInteger.TEN);
    }
}