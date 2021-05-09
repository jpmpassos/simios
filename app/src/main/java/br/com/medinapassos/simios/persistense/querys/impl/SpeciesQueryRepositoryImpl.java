package br.com.medinapassos.simios.persistense.querys.impl;

import br.com.medinapassos.simios.persistense.dto.StatsDto;
import br.com.medinapassos.simios.persistense.querys.SpeciesQueryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

import static br.com.medinapassos.simios.persistense.commons.ProcessStatsCommon.process;

@Slf4j
public class SpeciesQueryRepositoryImpl implements SpeciesQueryRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Optional<StatsDto> statsQuery() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final StringBuffer buffer = new StringBuffer();

        try {
            entityManager.getTransaction().begin();

            buffer.append("  SELECT sum(CASE WHEN type_species = 'HUMAN' THEN 1 ELSE 0 END ) as count_human_dna, ");
            buffer.append("         sum(CASE WHEN type_species = 'SIMIAN' THEN 1 ELSE 0 END ) as count_simian_dna ");
            buffer.append("    FROM species ");

            final Object[] objects = (Object[]) entityManager.createNativeQuery(buffer.toString()).getSingleResult();

            entityManager.getTransaction().commit();
            return process(objects);
        } catch (final Exception e) {
            entityManager.getTransaction().rollback();
            log.error("Erro ao realizar consulta.", e);
            return Optional.empty();
        } finally {
            entityManager.close();
        }

    }
}
