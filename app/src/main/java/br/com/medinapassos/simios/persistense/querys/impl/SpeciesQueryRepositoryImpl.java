package br.com.medinapassos.simios.persistense.querys.impl;

import br.com.medinapassos.simios.persistense.dto.StatsDto;
import br.com.medinapassos.simios.persistense.querys.SpeciesQueryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

import static br.com.medinapassos.simios.persistense.commons.ProcessStatsCommon.process;

@Slf4j
public class SpeciesQueryRepositoryImpl implements SpeciesQueryRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @PostConstruct
    private void postConstruct() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Optional<StatsDto> statsQuery() {
        final var buffer = new StringBuffer();
        try {
            buffer.append("  SELECT sum(CASE WHEN type_species = 'HUMAN' THEN 1 ELSE 0 END ) as count_human_dna, ");
            buffer.append("         sum(CASE WHEN type_species = 'SIMIAN' THEN 1 ELSE 0 END ) as count_simian_dna ");
            buffer.append("    FROM species ");

            final var objects = (Object[]) entityManager.createNativeQuery(buffer.toString()).getSingleResult();

            return process(objects);
        } catch (final Exception e) {
            log.error("Erro ao realizar consulta.", e);
            return Optional.empty();
        }
    }
}
