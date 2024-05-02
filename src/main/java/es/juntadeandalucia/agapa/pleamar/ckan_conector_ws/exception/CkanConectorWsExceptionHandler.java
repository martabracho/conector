package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.exception;


import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.controller.BoyaGrandeController;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@ControllerAdvice
public class CkanConectorWsExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(CkanConectorWsExceptionHandler.class);

    @ExceptionHandler({ CkanConectorWsValidacionException.class })
    public ResponseEntity<Object> handleCkanConectorWsValidacion(CkanConectorWsValidacionException ex, WebRequest request) {
        logger.debug("CkanConectorWsValidacionException", ex);
        ErrorDTO error = new ErrorDTO(HttpStatus.BAD_REQUEST,ex.getMessage(), request.getContextPath());
        return this.handleExceptionInternal(ex,error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
