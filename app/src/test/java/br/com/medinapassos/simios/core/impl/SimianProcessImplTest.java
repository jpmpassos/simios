package br.com.medinapassos.simios.core.impl;

import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.persistense.entity.enums.TypeSpeciesEnum;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimianProcessImplTest {

    private final SimianProcessImpl simianProcess = new SimianProcessImpl();

    @Test
    void testVertical() {
        final List<String> list = List.of("CTGAGA", "CTATGC", "TATTGT", "AGACGG", "CCCCTA", "TCACTG");
        final SpeciesDto speciesDto = SpeciesDto.builder().dna(list).build();
        final TypeSpeciesEnum typeSpeciesEnum = simianProcess.process(list);

        assertEquals(typeSpeciesEnum, TypeSpeciesEnum.SIMIAN);
    }

    @Test
    void testVertical2() {
        final var list = List.of("CTTTTF", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");

        final var speciesDto = SpeciesDto.builder().dna(list).build();
        final var typeSpeciesEnum = simianProcess.process(list);

        assertEquals(typeSpeciesEnum, TypeSpeciesEnum.HUMAN);
    }
}

