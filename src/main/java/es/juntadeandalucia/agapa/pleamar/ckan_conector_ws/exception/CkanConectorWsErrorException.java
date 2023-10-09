package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.exception;

/**
 * Esta excepción engloba aquellos errores que no son posibles ser recuperados/manejados por parte del cliente,
 * como caídas de los webservices a los que se conecta el CkanConectorWs.
 */
public class CkanConectorWsErrorException extends RuntimeException{

    String mensajeError = null;

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public CkanConectorWsErrorException(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "CkanConectorWsErrorException{" +
                "mensajeError='" + mensajeError + '\'' +
                '}';
    }
}
