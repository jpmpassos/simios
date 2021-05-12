package br.com.medinapassos.simios.core.impl;

import br.com.medinapassos.simios.core.SimianProcess;
import br.com.medinapassos.simios.persistense.entity.enums.TypeSpeciesEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SimianProcessImpl implements SimianProcess {

    @Override
    public TypeSpeciesEnum process(final List<String> list) {
        final var start = System.currentTimeMillis();
        TypeSpeciesEnum typeSpeciesEnum = null;
        try {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (testVertical(list, i, 0)) count++;
                if (testHorizontal(list, 0, i)) count++;

                if (testDiagonalUp(list, 0, i)) count++;
                if (!(list.size() - (i + 1) < 3) && testDiagonalUp(list, i, list.size() - 1)) count++;
                if (testDiagonalDown(list, i, 0)) count++;
                if (testDiagonalDown(list, 0, i)) count++;
            }
            typeSpeciesEnum = count >= 2 ? TypeSpeciesEnum.SIMIAN : TypeSpeciesEnum.HUMAN;
            return typeSpeciesEnum;
        } finally {
            log.info("Tempo gasto para concluir que a Espécie é do tipo {}: {}ms", typeSpeciesEnum.name(), System.currentTimeMillis() - start);
        }
    }

    public boolean testVertical(final List<String> list, final int x, final int y) {
        if (list.size() - (y + 1) < 3)
            return false;

        final String pivor = list.get(x).substring(y, y + 1);

        int yAux = y + 1;
        int count = 0;
        String strAux;

        final Boolean fim = true;
        while (fim) {
            if (yAux == list.size()) {
                return false;
            }
            strAux = list.get(x).substring(yAux, yAux + 1);
            if (pivor.equals(strAux)) {
                count++;
                yAux++;
            } else {
                return testVertical(list, x, yAux);
            }
            if (count == 3) {
                return true;
            }
        }
        return true;
    }

    public boolean testHorizontal(final List<String> list, final int x, final int y) {
        if (list.size() - (x + 1) < 3)
            return false;

        final String pivor = list.get(x).substring(y, y + 1);

        int xAux = x + 1;

        int count = 0;
        String strAux;
        final Boolean fim = true;
        while (fim) {
            if (xAux == list.size()) {
                return false;
            }
            strAux = list.get(xAux).substring(y, y + 1);
            if (pivor.equals(strAux)) {
                count++;
                xAux++;
            } else {
                return testHorizontal(list, xAux, y);
            }
            if (count == 3) {
                return true;
            }
        }
        return true;
    }

    public boolean testDiagonalUp(final List<String> list, final int x, final int y) {
        if ((y + 1 < 4) || (list.size() - (x + 1) < 3))
            return false;

        final Boolean fim = true;

        final String pivor = list.get(y).substring(x, x + 1);

        int xAux = x + 1;
        int yAux = y - 1;

        int count = 0;
        String strAux;
        while (fim) {
            if (xAux == list.size() || yAux == list.size()) {
                return false;
            }
            strAux = list.get(yAux).substring(xAux, xAux + 1);

            if (pivor.equals(strAux)) {
                count++;
                xAux++;
                yAux--;
            } else {
                return testDiagonalUp(list, xAux, yAux);
            }
            if (count == 3) {
                return true;
            }
        }
        return true;
    }

    public boolean testDiagonalDown(final List<String> list, final int x, final int y) {
        if ((list.size() - (x + 1) < 4) || (list.size() - (y + 1) < 4))
            return false;

        final String pivor = list.get(y).substring(x, x + 1);

        int xAux = x + 1;
        int yAux = y + 1;

        int count = 0;
        String strAux;
        final Boolean fim = true;
        while (fim) {
            if (xAux == list.size() || yAux == list.size()) {
                return false;
            }
            strAux = list.get(yAux).substring(xAux, xAux + 1);
            if (pivor.equals(strAux)) {
                count++;
                xAux++;
                yAux++;
            } else {
                return testDiagonalDown(list, xAux, yAux);
            }
            if (count == 3) {
                return true;
            }
        }
        return true;
    }
}
