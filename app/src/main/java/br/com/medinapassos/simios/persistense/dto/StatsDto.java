package br.com.medinapassos.simios.persistense.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatsDto {
    @Column(name = "count_human_dna")
    private BigInteger countHumanDna;
    @Column(name = "count_simian_dna")
    private BigInteger countSimianDna;
}
