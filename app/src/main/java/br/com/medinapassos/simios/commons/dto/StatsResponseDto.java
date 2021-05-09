package br.com.medinapassos.simios.commons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatsResponseDto {
    @JsonProperty("count_simian_dna")
    private int countSimianDna;
    @JsonProperty("count_human_dna")
    private int countHumanDna;
    @JsonProperty("ratio")
    private BigDecimal ratio;
}
