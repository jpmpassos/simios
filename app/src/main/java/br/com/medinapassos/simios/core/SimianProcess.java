package br.com.medinapassos.simios.core;

import br.com.medinapassos.simios.persistense.entity.enums.TypeSpeciesEnum;

import java.util.List;

public interface SimianProcess {
    TypeSpeciesEnum process(List<String> list);
}
