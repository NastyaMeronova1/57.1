//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        getConnection();
        GeoPlugin root = new GeoPlugin();
        Document document;
        try {
            document = buildDocument();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        Node rootNode = document.getFirstChild();
        NodeList rootChild = rootNode.getChildNodes();
        String geoPlugin = null;
        for (int i = 0; i < rootChild.getLength(); i++) {
            if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (rootChild.item(i).getNodeName()) {
                case "geoplugin_request": {
                    geoPlugin = rootChild.item(i).getTextContent();
                    root.setGeoplugin_request(geoPlugin);
                    break;
                }
                case "geoplugin_status": {
                    root.setGeoplugin_status(rootChild.item(i).getTextContent());
                    break;
                }
                case "geoplugin_delay": {
                    root.setGeoplugin_delay(rootChild.item(i).getTextContent());
                    break;
                }
                case "geoplugin_credit": {
                    root.setGeoplugin_credit((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_city": {
                    root.setGeoplugin_city((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_region": {
                    root.setGeoplugin_region((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_regionCode": {
                    root.setGeoplugin_regionCode((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_regionName": {
                    root.setGeoplugin_regionName((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_areaCode": {
                    root.setGeoplugin_areaCode((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_dmaCode": {
                    root.setGeoplugin_dmaCode((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_countryCode": {
                    root.setGeoplugin_countryCode((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_countryName": {
                    root.setGeoplugin_countryName((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_inEU": {
                    root.setGeoplugin_inEU((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_euVATrate": {
                    root.setGeoplugin_euVATrate((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_continentCode": {
                    root.setGeoplugin_continentCode((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_continentName": {
                    root.setGeoplugin_continentName((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_latitude": {
                    root.setGeoplugin_latitude((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_longitude": {
                    root.setGeoplugin_longitude((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_locationAccuracyRadius": {
                    root.setGeoplugin_locationAccuracyRadius((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_timezone": {
                    root.setGeoplugin_timezone((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_currencyCode": {
                    root.setGeoplugin_currencyCode((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_currencySymbol": {
                    root.setGeoplugin_currencySymbol((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_currencySymbol_UTF8": {
                    root.setGeoplugin_currencySymbol_UTF8((rootChild.item(i).getTextContent()));
                    break;
                }
                case "geoplugin_currencyConverter": {
                    root.setGeoplugin_currencyConverter((rootChild.item(i).getTextContent()));
                    break;
                }
            }
        }
        root.setGeoplugin_request(geoPlugin);
        System.out.println(root.toString());
    }

    private static void getConnection() {
        HttpURLConnection connection;
        StringBuffer response = new StringBuffer();

        try {
            URL url = new URL("http://www.geoplugin.net/xml.gp?base_currency=USD");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            BufferedReader reader;
            String line;
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
            }

            System.out.println(response);
        } catch (MalformedURLException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }

    private static Document buildDocument() throws Exception {
        File file = new File("test.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        return document = factory.newDocumentBuilder().parse(file);

    }

}
