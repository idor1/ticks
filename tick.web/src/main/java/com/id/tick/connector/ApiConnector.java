package com.id.tick.connector;

import com.google.gson.Gson;
import com.id.tick.dto.Route;
import com.id.tick.dto.Station;
import com.id.tick.dto.Stations;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created on 18.06.2015.
 */
@Service
@PropertySource("classpath:api-pwd.properties")
public class ApiConnector {

    private static Logger logger = Logger.getLogger(ApiConnector.class);

    private final String USER_AGENT = "Mozilla/5.0";

    @Value("${login}")
    private String login;

    @Value("${password}")
    private String password;

    @Value("${target.host}")
    private String host;


    public Collection<Station> getDepartures(String criteria) {
        Collection<Station> stations = new ArrayList<Station>();
        try {
            String authStr = login + ":" + password;
            String departuresUrl = "https://" + host + "/departure_stations/ru/rw/0/" + URLEncoder.encode(criteria, "UTF-8");

            stations = getStations(departuresUrl, authStr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }

    public Collection<Station> getArrivals(String criteria) {
        Collection<Station> stations = new ArrayList<Station>();
        try {
            String authStr = login + ":" + password;
            String departuresUrl = "https://" + host + "/arrive_stations/ru/rw/0/" + URLEncoder.encode(criteria, "UTF-8");

            stations = getStations(departuresUrl, authStr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }

    public Route findRoute(String departureStation, String arrivalStation) {
        return new Route();
    }

    private Collection<Station> getStations(String urlString, String authStr) throws IOException {
        String encoded = Base64.encodeBase64String(authStr.getBytes());

        URL url = new URL(urlString);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.setRequestProperty("Authorization", "Basic " + encoded);
        con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");

        BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        String line = "";
        StringBuffer content = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            content.append(line);
        }

        return parseStations(content);
    }

    private Collection<Station> parseStations(StringBuffer content) {
        Gson gson = new Gson();

        Stations dtoStations = gson.fromJson(content.toString(), Stations.class);

        return dtoStations.getStations();
    }
}
