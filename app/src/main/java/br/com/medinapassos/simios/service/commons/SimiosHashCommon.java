package br.com.medinapassos.simios.service.commons;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

@Slf4j
public class SimiosHashCommon {

    public static String hashGenerator(final List<String> dna) {
        final var hash = dna.hashCode();
        log.info("Hash da lista DNA = {}", hash);
        final var sharIdentificator = sha256Hex(String.valueOf(hash));
        log.info("Identificador do DNA = {}", sharIdentificator);
        return sharIdentificator;
    }
}
