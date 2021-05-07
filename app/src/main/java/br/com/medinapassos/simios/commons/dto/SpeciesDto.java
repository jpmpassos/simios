package br.com.medinapassos.simios.commons.dto;

import br.com.medinapassos.simios.commons.dto.enums.TypeSpeciesEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SpeciesDto {
    @JsonProperty("dna")
    private List<String> dna;
    @JsonIgnoreProperties
    private TypeSpeciesEnum typeSpecies;
}
