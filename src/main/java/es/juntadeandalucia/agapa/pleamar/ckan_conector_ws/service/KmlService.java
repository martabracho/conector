package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KmlService {

    public String convertirGenerarKML(BoyaChica boyaChica){
        StringBuilder kml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        kml.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n");
        kml.append("<Document>\n");
        kml.append("<Placemark>\n");
   //     kml.append("<description> Significant wave height (m): " + hm0
   //             + "<br/> Sea surface temperature (deg C): " + sst + "<br/> Time: " + tstr + "</description>\n");
        kml.append("<Point>\n");
        kml.append("<coordinates>" + boyaChica.getLongitude() + "," + boyaChica.getLatitude() + "</coordinates>\n");
        kml.append("</Point>\n");
        kml.append("</Placemark>");

        kml.append("</Document>\n");
        kml.append("</kml>\n");

        return kml.toString();
    }
}
