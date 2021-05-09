package br.com.medinapassos.simios.persistense.entity;


import br.com.medinapassos.simios.persistense.entity.enums.TypeSpeciesEnum;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "species")
@SequenceGenerator(name = "species_species_id_seq", sequenceName = "species_species_id_seq", allocationSize = 1)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class SpeciesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "species_species_id_seq")
    @Column(name = "species_id")
    private Integer speciesId;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<String> dna;
    @Column(name = "identificator")
    private String identificator;
    @Column(name = "type_species")
    @Enumerated(EnumType.STRING)
    private TypeSpeciesEnum typeSpecies;
}
