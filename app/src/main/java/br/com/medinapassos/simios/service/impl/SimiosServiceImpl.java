package br.com.medinapassos.simios.service.impl;

import br.com.medinapassos.simios.commons.dto.ResponseDto;
import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.commons.dto.StatsResponseDto;
import br.com.medinapassos.simios.commons.exception.enums.SimiosExceptionEnum;
import br.com.medinapassos.simios.commons.exception.factory.SimiosExceptionFactory;
import br.com.medinapassos.simios.core.SimianProcess;
import br.com.medinapassos.simios.persistense.entity.SpeciesEntity;
import br.com.medinapassos.simios.persistense.entity.enums.TypeSpeciesEnum;
import br.com.medinapassos.simios.persistense.repository.SpeciesRepository;
import br.com.medinapassos.simios.service.SimiosService;
import br.com.medinapassos.simios.service.mappers.SpeciesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import static br.com.medinapassos.simios.commons.exception.enums.SimiosExceptionEnum.UNIQUE_INDEX_SPECIES;
import static br.com.medinapassos.simios.commons.exception.factory.SimiosExceptionFactory.throwException;
import static br.com.medinapassos.simios.service.commons.SimiosHashCommon.hashGenerator;
import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@Service
public class SimiosServiceImpl implements SimiosService {

    @Autowired
    private SimianProcess simianProcess;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private SpeciesMapper speciesMapper;

    @Override
    public ResponseDto save(final SpeciesDto speciesDto) {

        final SpeciesEntity speciesEntity = speciesMapper.toEntity(speciesDto);

        speciesEntity.setTypeSpecies(simianProcess.process(speciesDto.getDna()));
        speciesEntity.setIdentificator(hashGenerator(speciesDto.getDna()));

        SpeciesEntity response = null;

        try {
            response = speciesRepository.save(speciesEntity);
            log.info("Gravação com sucesso da Species.", keyValue("entity_persisted", response));
        } catch (final DataIntegrityViolationException dataIntegrityViolationException) {
            log.error("Erro ao gravar Espécie.", dataIntegrityViolationException);
            throwException(UNIQUE_INDEX_SPECIES);
        }
        return ResponseDto
                .builder()
                .isSimian(response.getTypeSpecies().equals(TypeSpeciesEnum.SIMIAN))
                .build();
    }

    @Override
    public StatsResponseDto getStats() {
        return speciesRepository.statsQuery().map((stats) -> speciesMapper.toStatsResponseDto(stats)).orElseThrow(() -> {
            SimiosExceptionFactory.throwException(SimiosExceptionEnum.ERROR_SQL_UNEXPECTED);
            return null;
        });

    }
}
