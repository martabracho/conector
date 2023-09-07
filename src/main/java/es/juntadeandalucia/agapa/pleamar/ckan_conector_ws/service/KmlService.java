package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.Proyecto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KmlService {

    public String convertirGenerarKML(List<Proyecto> boyaSChicas){
        StringBuilder kml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        kml.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n");
        kml.append("<Document>\n");
        for(Proyecto proyecto : boyaSChicas){
            kml.append("<Placemark>\n");
            //     kml.append("<description> Significant wave height (m): " + hm0
            //             + "<br/> Sea surface temperature (deg C): " + sst + "<br/> Time: " + tstr + "</description>\n");
            kml.append("<Point>\n");
           // kml.append("<coordinates>" + proyecto.getLongitude() + "," + proyecto.getLatitude() + "</coordinates>\n");
            kml.append("</Point>\n");
            kml.append("</Placemark>");
        }
        kml.append("</Document>\n");
        kml.append("</kml>\n");
        return kml.toString();
    }
}
