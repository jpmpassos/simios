package br.com.medinapassos.simios.commons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatsResponseDto {
    @JsonProperty("count_simian_dna")
    private BigInteger countSimianDna;
    @JsonProperty("count_human_dna")
    private BigInteger countHumanDna;
    @JsonProperty("ratio")
    private BigDecimal ratio;
}
