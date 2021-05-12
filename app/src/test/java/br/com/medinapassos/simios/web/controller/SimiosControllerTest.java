package br.com.medinapassos.simios.web.controller;

import br.com.medinapassos.simios.core.SimianProcess;
import br.com.medinapassos.simios.core.impl.SimianProcessImpl;
import br.com.medinapassos.simios.exceptionhandler.SimiosExceptionHandler;
import br.com.medinapassos.simios.persistense.entity.SpeciesEntity;
import br.com.medinapassos.simios.persistense.repository.SpeciesRepository;
import br.com.medinapassos.simios.service.SimiosService;
import br.com.medinapassos.simios.service.impl.SimiosServiceImpl;
import br.com.medinapassos.simios.service.mappers.SpeciesMapper;
import br.com.medinapassos.simios.service.mappers.impl.SpeciesMapperImpl;
import br.com.medinapassos.simios.test.Mocks;
import br.com.medinapassos.simios.web.validation.SimiosValidate;
import br.com.medinapassos.simios.web.validation.impl.SimiosValidateImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

//@WebMvcTest(SimiosController.class)
//@ActiveProfiles("test")
public class SimiosControllerTest {

    private static final String SIMIAM_URL = "/simian";
    private static final String STATS_URL = "/stats";
    @Mock
    private SpeciesRepository speciesRepository;

    private SimiosService simiosService;

    private SimiosValidate simiosValidate;

    @Autowired
    private SimianProcess simianProcess;

    @Autowired
    private SpeciesMapper speciesMapper;

    @InjectMocks
    private SimiosController simiosController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {

        initMocks(this);
        mockMvc = standaloneSetup(simiosController)
                .setControllerAdvice(new SimiosExceptionHandler()).build();

        simiosService = new SimiosServiceImpl();
        simiosValidate = new SimiosValidateImpl();
        simianProcess = new SimianProcessImpl();
        speciesMapper = new SpeciesMapperImpl();

        setField(simiosService, "speciesRepository", speciesRepository);
        setField(simiosService, "simianProcess", simianProcess);
        setField(simiosService, "speciesMapper", speciesMapper);
        setField(simiosController, "simiosService", simiosService);
        setField(simiosController, "simiosValidate", simiosValidate);
    }

    @org.junit.jupiter.api.Test
    public void postSpecies() throws Exception {
        when(speciesRepository.save(any(SpeciesEntity.class))).thenReturn(Mocks.getSpecies());

        mockMvc.perform(post(SIMIAM_URL)
                .content(Mocks.getSpeciesJson())
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getStats() throws Exception {
        when(speciesRepository.statsQuery()).thenReturn(Mocks.getStats());

        mockMvc.perform(get(STATS_URL)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)).andExpect(status().isOk());
    }
}