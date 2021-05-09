CREATE UNIQUE INDEX species_identificator_index
    ON species USING btree
    (identificator text_pattern_ops ASC NULLS LAST)
    TABLESPACE pg_default;

CREATE UNIQUE INDEX species_type_species_index
    ON species USING btree
    (type_species text_pattern_ops ASC NULLS LAST)
    TABLESPACE pg_default;