package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.service;

import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrande;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrandeData;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrandeTracks;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.repository.BoyaGrandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Controller
public class BoyaGrandeService {

    private final BoyaGrandeRepository boyaGrandeRepository;

    @Autowired
    public BoyaGrandeService(BoyaGrandeRepository boyaGrandeRepository) {
        this.boyaGrandeRepository = boyaGrandeRepository;
    }

    public String getToken()  {
        return this.boyaGrandeRepository.getToken();
    }


    public BoyaGrande getBoyaUltimoTrack(long idBoya) {
        String token = this.boyaGrandeRepository.getToken();
        return this.boyaGrandeRepository.getBoyaUltimoTrack(token, idBoya);
    }

    public BoyaGrandeTracks getBoyaTracks(long idBoya) {
        String token = this.boyaGrandeRepository.getToken();
        return this.boyaGrandeRepository.getBoyaTracks(token, idBoya);
    }

    public BoyaGrandeTracks getBoyaFilterDates(long idBoya, String fechaIncio, String fechaFin){
        String token = this.boyaGrandeRepository.getToken();
        return this.boyaGrandeRepository.getBoyaFilterTracks(token, idBoya,fechaIncio,fechaFin);
    }

    public String getKml() {

        StringBuilder kml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        kml.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n");
        kml.append("<Document>\n");
        List<Integer> idsBoya = Arrays.asList(2, 3, 4, 5);

        List<BoyaGrande> listaBoyas = idsBoya.stream().parallel().map( idBoya -> {
            BoyaGrande boyaGrande;
            boyaGrande =  this.getBoyaUltimoTrack(idBoya);
            boyaGrande.setId(String.valueOf(idBoya));
            return boyaGrande;
        }  ).toList();


        for (BoyaGrande boyaGrande: listaBoyas){
            if("2".equals(boyaGrande.getId())) {
                kml.append(this.getKml(boyaGrande, "HUELVA"));
            }else if("3".equals(boyaGrande.getId())){
                kml.append(this.getKml(boyaGrande, "ALMERÍA"));
            }else if ("4".equals(boyaGrande.getId())){
            	kml.append(this.getKml(boyaGrande, "CÁDIZ"));
            }else if ("5".equals(boyaGrande.getId())){
            	kml.append(this.getKml(boyaGrande, "GRANADA"));
            }
        }

        kml.append("</Document>\n");
        kml.append("</kml>\n");
        return kml.toString();
    }

    private String getKml(BoyaGrande boyaGrande, String name){
        StringBuilder kml = new StringBuilder();
        kml.append("<Placemark>\n");
        kml.append("<name>").append(name).append("</name>");
        kml.append("<description>");
        for(BoyaGrandeData data : boyaGrande.getData()){
            kml.append(data.toStringFormatoKML());
        }
        kml.append("</description>");
        kml.append("<Point>\n");
        kml.append("<coordinates>" + boyaGrande.getLongitude() + "," + boyaGrande.getLatitude() + "</coordinates>\n");
        kml.append("</Point>\n");
        kml.append("</Placemark>");
        return kml.toString();
    }

    public List<BoyaGrande> getUltimoTrack() {
        List<BoyaGrande> listaBoyasGrandes;
        List<Integer> idsBoya = Arrays.asList(2, 3, 4, 5);
        listaBoyasGrandes = idsBoya.stream().parallel().map( idBoya -> {
            BoyaGrande boyaGrande;
            boyaGrande =  this.getBoyaUltimoTrack(idBoya);
            boyaGrande.setId(String.valueOf(idBoya));
            return boyaGrande;
        }  ).toList();
        return listaBoyasGrandes;
    }
}
