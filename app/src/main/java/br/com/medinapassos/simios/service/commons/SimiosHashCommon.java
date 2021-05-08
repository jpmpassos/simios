package br.com.medinapassos.simios.service.commons;

import java.util.List;
import java.util.Objects;

public class SimiosHashCommon {
    public static int hashGenerator(final List<String> dna) {
        return Objects.hash(dna.toArray());
    }
}
