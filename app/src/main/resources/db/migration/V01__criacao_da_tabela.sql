CREATE TABLE species
(
    species_id serial NOT NULL,
    identificator text NOT NULL,
    type_species text NOT NULL,
    dna jsonb NOT NULL,
    PRIMARY KEY (species_id),
    UNIQUE (identificator)

)
WITH (
    OIDS = FALSE
);

ALTER TABLE species
    OWNER to simiosuser;