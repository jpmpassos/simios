package br.com.medinapassos.simios.persistense.commons;

import br.com.medinapassos.simios.persistense.dto.StatsDto;

import java.math.BigInteger;
import java.util.Optional;

public class ProcessStatsCommon {
    public static Optional<StatsDto> process(final Object[] objects) {
        return Optional.of(StatsDto.builder()
                .countHumanDna((BigInteger) objects[0])
                .countSimianDna((BigInteger) objects[1])
                .build());
    }
}
