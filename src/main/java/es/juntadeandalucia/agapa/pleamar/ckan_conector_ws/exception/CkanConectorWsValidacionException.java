package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.exception;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.util.StringUtils;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

/**
 * Esta excepción engloba aquellos errores que sí son posibles ser recuperados/manejados por parte del cliente,
 * como haber introducido valores erróne
 * os en los parámetros de invocación al CkanConectorWs.
 */
public class CkanConectorWsValidacionException extends RuntimeException  {

    public CkanConectorWsValidacionException(String mensajeValidacion) {
        super(mensajeValidacion);
    }

    public CkanConectorWsValidacionException(Collection<String> mensajesValidacion) {
        super(StringUtils.collectionToDelimitedString( mensajesValidacion,"\n"));
    }

}
