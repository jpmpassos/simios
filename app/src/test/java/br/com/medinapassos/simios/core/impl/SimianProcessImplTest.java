package br.com.medinapassos.simios.core.impl;

import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.persistense.entity.enums.TypeSpeciesEnum;
import org.junit.jupiter.api.Test;

import java.util.List;

class SimianProcessImplTest {

    private final SimianProcessImpl simianProcess = new SimianProcessImpl();

    @Test
    void testVertical() {
//        List<String> list = List.of("CTTTTF", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
        final List<String> list = List.of(
                "CTGAGA",
                "CTATGC",
                "TATTGT",
                "AGACGG",
                "CCCCTA",
                "TCACTG"
        );
        final SpeciesDto speciesDto = SpeciesDto.builder().dna(list).build();
        final TypeSpeciesEnum typeSpeciesEnum = simianProcess.process(list);
        System.out.println(speciesDto.toString());
    }
}

