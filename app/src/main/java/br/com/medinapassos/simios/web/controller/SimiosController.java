package br.com.medinapassos.simios.web.controller;

import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.service.SimiosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@RestController
@RequestMapping("/simios")
public class SimiosController {

    @Autowired
    private SimiosService simiosService;

    @PostMapping
    public ResponseEntity<SpeciesDto> postSpecies(@RequestBody final SpeciesDto speciesDto) {
        log.info("stage=init inserção de uma espécie.", keyValue("request_body", speciesDto));

        final SpeciesDto response = simiosService.save(speciesDto);

        log.info("stage=end inserção de uma espécie.", keyValue("response", response));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
