package br.com.medinapassos.simios.commons.exception.factory;

import br.com.medinapassos.simios.commons.exception.ErrorDetails;
import br.com.medinapassos.simios.commons.exception.SimiosException;
import br.com.medinapassos.simios.commons.exception.enums.SimiosExceptionEnum;

import java.util.List;

public class SimiosExceptionFactory {
    public static void throwException(final SimiosExceptionEnum simiosExceptionEnum) {
        throw SimiosException.builder().errorDetails(ErrorDetails.builder()
                .errors(List.of(simiosExceptionEnum.getMessage()))
                .httpStatus(simiosExceptionEnum.getHttpStatus())
                .status(simiosExceptionEnum.getHttpStatus().value())
                .build()).build();
    }

    public static SimiosException createException(final SimiosExceptionEnum simiosExceptionEnum) {
        return SimiosException.builder().errorDetails(ErrorDetails.builder()
                .errors(List.of(simiosExceptionEnum.getMessage()))
                .httpStatus(simiosExceptionEnum.getHttpStatus())
                .status(simiosExceptionEnum.getHttpStatus().value())
                .build()).build();
    }
}
