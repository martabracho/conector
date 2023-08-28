package com.agapa.pleamar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.*;

public class Main {

	// public final static String FILENAME ="D:/Usuarios/mbracho/Documents/Pleamar/Conversor/ListadoGeneral.json";
	// public final static String FILENAME ="D:/Usuarios/mbracho/Documents/Pleamar/Conversor/AgapaBallena.json";
	public final static String FILENAME = "D:/Usuarios/mbracho/Documents/Pleamar/Conversor/4474.json";

	public static void main(String[] args) throws IOException {

		JSONParser parser = new JSONParser();
		FileReader fileReader;

		File file = new File(FILENAME);
		fileReader = new FileReader(file);

		String filenameKML = "D:/Usuarios/mbracho/Documents/Pleamar/Conversor/4474.kml";
		FileWriter fichero = null;
		PrintWriter pw = null;

		// Parser returns an object, we need an explicit cast to covert it into a
		// JSONArray
		JSONArray array;
		try {
			array = (JSONArray) parser.parse(fileReader);

			// ABRIR LA ESCRITURA
			fichero = new FileWriter(filenameKML);
			pw = new PrintWriter(fichero);

			// Cabecera kml
			pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.println(
					"<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">");
			pw.println("<Document>");

			// Traverse the list
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = (JSONObject) array.get(i);
				// parseObject(obj,"General");
				// parseObject(obj, "project");
				parseObject(obj, "station", pw);

			}

			// cierre kml
			pw.println("</Document>");
			pw.println("</kml>");

			
		} catch (Exception e) {

			e.printStackTrace();
		// CERRAR LA ESCRITURA
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	private static void parseObject(JSONObject obj, String type, PrintWriter pw) {

		switch (type)

		{

		case "General":
			String name = (String) obj.get("name");
			System.out.println("Name: " + name);

			break;
		case "project":
			String id = (String) obj.get("id");
			System.out.println("Id: " + id);
			name = (String) obj.get("name");
			System.out.println("Name: " + name);
			String latitude = (String) obj.get("latitude");
			System.out.println("Latitude: " + latitude);
			String longitude = (String) obj.get("longitude");
			System.out.println("Longitude: " + longitude);
			break;
		case "station":

			System.out.println("============================");
			
			Double hm0 = (Double) obj.get("Hm0");
			System.out.println("Significant wave height (m) " + hm0);

			Double lat = (Double) obj.get("lat");
			System.out.println("Latitude: " + lat);
			
			Double lon = (Double) obj.get("lon");
			System.out.println("Longitude: " + lon);

			Double sst = Double.parseDouble(obj.get("sst").toString());
			System.out.println("Sea surface temperature: " + sst);

			String tstr = (String) obj.get("tstr");
			System.out.println("Time: " + tstr);

			System.out.println();

			pw.println("<Placemark>");
			pw.println("<description> Significant wave height (m): " + hm0
					+ "<br/> Sea surface temperature (deg C): " + sst + "<br/> Time: " + tstr + "</description>");
			pw.println("<Point>");
			pw.println("<coordinates>" + lon + "," + lat + "</coordinates>");
			pw.println("</Point>");
			pw.println("</Placemark>");

			break;

		}

	}

}
