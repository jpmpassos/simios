package br.com.medinapassos.simios.persistense.querys.impl;

import br.com.medinapassos.simios.persistense.querys.SpeciesQueryRepository;
import br.com.medinapassos.simios.test.Mocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.math.BigInteger;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.util.ReflectionTestUtils.setField;

class SpeciesQueryRepositoryImplTest {

    @Mock
    private EntityManagerFactory entityManagerFactory;

    @Mock
    private EntityManager entityManager;

    private SpeciesQueryRepository speciesQueryRepository;

    @Mock
    private Query query;

    @Mock
    private EntityTransaction entityTransaction;

    @BeforeEach
    void setUp() {
        initMocks(this);

        entityManager = Mockito.mock(EntityManager.class);

        speciesQueryRepository = new SpeciesQueryRepositoryImpl();

        setField(speciesQueryRepository, "entityManagerFactory", entityManagerFactory);
        setField(speciesQueryRepository, "entityManager", entityManager);
    }

    @Test
    void statsQuery() {

        doNothing().when(entityTransaction).begin();
        doNothing().when(entityTransaction).commit();
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        when(query.getSingleResult()).thenReturn(Mocks.getObjtcs());
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        final var result = speciesQueryRepository.statsQuery();
        Assertions.assertEquals(result.orElseThrow().getCountHumanDna(), BigInteger.ONE);
        Assertions.assertEquals(result.orElseThrow().getCountSimianDna(), BigInteger.TEN);
    }
}