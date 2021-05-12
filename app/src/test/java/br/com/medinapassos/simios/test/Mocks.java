package br.com.medinapassos.simios.test;

import br.com.medinapassos.simios.persistense.dto.StatsDto;
import br.com.medinapassos.simios.persistense.entity.SpeciesEntity;
import br.com.medinapassos.simios.persistense.entity.enums.TypeSpeciesEnum;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Mocks {
    public static SpeciesEntity getSpecies() {
        return SpeciesEntity.builder()
                .dna(List.of("ATGAGA", "CTATGC", "TTTTGT", "CGACGG", "ACCCTA", "TCACTA"))
                .identificator("teste_identificador")
                .typeSpecies(TypeSpeciesEnum.SIMIAN)
                .speciesId(12)
                .build();
    }

    public static String getSpeciesJson() {
        return "{\n" +
                "    \"dna\": [ \"ATGAGA\",\n" +
                "                \"CTATGC\",\n" +
                "                \"TTTTGT\",\n" +
                "                \"CGACGG\",\n" +
                "                \"ACCCTA\",\n" +
                "                \"TCACTA\"]\n" +
                "}";
    }

    public static Optional<StatsDto> getStats() {
        return Optional.of(StatsDto.builder().countHumanDna(BigInteger.ONE).countSimianDna(BigInteger.TEN).build());
    }

    public static Object[] getObjtcs() {
        final var objects = new ArrayList<Object>();
        objects.add(BigInteger.ONE);
        objects.add(BigInteger.TEN);
        return objects.toArray();
    }
}
