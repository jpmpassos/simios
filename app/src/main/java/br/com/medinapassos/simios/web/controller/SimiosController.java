package br.com.medinapassos.simios.web.controller;

import br.com.medinapassos.simios.commons.dto.ResponseDto;
import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.commons.dto.StatsResponseDto;
import br.com.medinapassos.simios.service.SimiosService;
import br.com.medinapassos.simios.web.validation.SimiosValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@RestController
public class SimiosController {

    @Autowired
    private SimiosService simiosService;

    @Autowired
    private SimiosValidate simiosValidate;

    @PostMapping
    @RequestMapping("/simian")
    public ResponseEntity<ResponseDto> postSpecies(@RequestBody final SpeciesDto speciesDto) {
        log.info("stage=init inserção de uma espécie.", keyValue("request_body", speciesDto));

        simiosValidate.validete(speciesDto);

        final var response = simiosService.save(speciesDto);

        log.info("stage=end inserção de uma espécie.", keyValue("response", response));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    @RequestMapping("/stats")
    public ResponseEntity<StatsResponseDto> getStats() {
        log.info("stage=init pesquisa da estatística dos simios.");

        final var response = simiosService.getStats();

        log.info("stage=end pesquisa da estatística dos simios.", keyValue("response", response));
        return ResponseEntity.ok().body(response);
    }
}
