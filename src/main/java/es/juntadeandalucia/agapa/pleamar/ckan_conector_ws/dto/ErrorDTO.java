package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.dto;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ErrorDTO {

    private ZonedDateTime timestamp = ZonedDateTime.now();
    private HttpStatus status;
    private String error;
    private String path = "path";

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public ErrorDTO(HttpStatus status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }
}
