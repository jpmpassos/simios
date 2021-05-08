package br.com.medinapassos.simios.exceptionhandler;

import br.com.medinapassos.simios.commons.exception.SimiosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@ControllerAdvice
public class SimiosExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({SimiosException.class})
    public ResponseEntity<Object> handlerSimiosException(final SimiosException simiosException,
                                                         final WebRequest webRequest) {

        log.error("Erro tratado: ", keyValue("error_detail", simiosException.getErrorDetails()));

        return ResponseEntity
                .status(simiosException.getErrorDetails().getHttpStatus())
                .body(simiosException.getErrorDetails());
    }
}
