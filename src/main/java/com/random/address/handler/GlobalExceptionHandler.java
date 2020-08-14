package com.random.address.handler;

import com.random.address.model.ServiceError;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles all the Exceptions thrown within the api and respond with a readable error json.
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    /**
     * @param illegalArgumentException when an un implemented country code is selected by the caller.
     * @return service error with code and message.
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public ServiceError illegalArgumentException(IllegalArgumentException illegalArgumentException) {
        log.error(illegalArgumentException::getMessage);
        return ServiceError.builder()
                .errorCode("400")
                .errorMessage(illegalArgumentException.getMessage())
                .build();
    }

    /**
     * @param exception any unknown exception object that is not handled by the application.
     * @return service error with code and message.
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ServiceError genericException(Exception exception) {
        log.error(exception::getMessage);
        return ServiceError.builder()
                .errorCode("500")
                .errorMessage(exception.getMessage())
                .build();
    }
}
