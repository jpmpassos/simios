package br.com.medinapassos.simios.core.impl;

import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimianProcessImplTest {

    private SimianProcessImpl simianProcess = new SimianProcessImpl();

    @Test
    void testVertical() {
//        List<String> list = List.of("CTTTTF", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
        List<String> list = List.of(
                "CTGAGA",
                "CTATGC",
                "TATTGT",
                "AGACGG",
                "CCCCTA",
                "TCACTG"
        );
        SpeciesDto speciesDto = SpeciesDto.builder().dna(list).build();
        speciesDto.setTypeSpecies(simianProcess.process(list));
        System.out.println(speciesDto.toString());
    }
}

