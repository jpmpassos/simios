package br.com.medinapassos.simios.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private HttpStatus httpStatus;
    private List<String> errors;
    @Builder.Default
    private Date timestamp = new Date();
    private int status;
}
