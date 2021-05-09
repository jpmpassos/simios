package br.com.medinapassos.simios.web.controller;

import br.com.medinapassos.simios.commons.dto.ResponseDto;
import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.service.SimiosService;
import br.com.medinapassos.simios.web.validation.SimiosValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SimiosValidate simiosValidate;

    @PostMapping
    public ResponseEntity<ResponseDto> postSpecies(@RequestBody final SpeciesDto speciesDto) {
        log.info("stage=init inserção de uma espécie.", keyValue("request_body", speciesDto));

        simiosValidate.validete(speciesDto);

        final ResponseDto response = simiosService.save(speciesDto);

        log.info("stage=end inserção de uma espécie.", keyValue("response", response));
        return ResponseEntity.ok().body(response);
    }
}
