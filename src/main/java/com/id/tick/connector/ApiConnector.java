package com.id.tick.connector;

import com.google.gson.Gson;
import com.id.tick.booking.CabinSeat;
import com.id.tick.dto.request.BillRequest;
import com.id.tick.dto.response.*;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;


/**
 * Created on 18.06.2015.
 */
@Service
@PropertySource("classpath:api-pwd.properties")
public class ApiConnector {

    private static Logger logger = Logger.getLogger(ApiConnector.class);

    @Value("${login}")
    private String login;

    @Value("${password}")
    private String password;

    @Value("${target.host}")
    private String host;

    private String authStr;

    @PostConstruct
    public void init() {
        authStr = login + ":" + password;
    }

    public Collection<Station> getDepartures(String criteria) {
        String departuresUrl = null;
        try {
            departuresUrl = "https://" + host + "/departure_stations/ru/rw/0/" + URLEncoder.encode(criteria, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Stations stations = get(departuresUrl, authStr, Stations.class);

        assert stations != null;

        return stations.getStations();
    }

    public Collection<Station> getArrivals(String criteria) {
        String arrivalsUrl = null;
        try {
            arrivalsUrl = "https://" + host + "/arrive_stations/ru/rw/0/" + URLEncoder.encode(criteria, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Stations stations = get(arrivalsUrl, authStr, Stations.class);

        assert stations != null;

        return stations.getStations();
    }

    public Route findRoute(String from, String to, String date) {
        String path = from + "/" + to + "/" + date;

        String routeUrl = "https://" + host + "/variants/ru/rw/" + path;

        Route route = get(routeUrl, authStr, Route.class);

        assert route != null;

        return route;
    }

    private <T> T get(String urlString, String authStr, Class<T> typeToGet) {
        HttpsURLConnection con = null;
        try {

            String encoded = Base64.encodeBase64String(authStr.getBytes());

            URL url = new URL(urlString);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setRequestProperty("Authorization", "Basic " + encoded);
            con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");

            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                content.append(line);
            }

            Gson gson = new Gson();


//            URLDecoder.decode(content.toString(), "UTF-8");
            return gson.fromJson(URLDecoder.decode(content.toString(), "UTF-8"), typeToGet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        return null;
    }

    private <T, P> T post(String urlString, String authStr, P payload, Class<T> typeToGet) {
        HttpsURLConnection con = null;
        try {

            String encoded = Base64.encodeBase64String(authStr.getBytes());

            URL url = new URL(urlString);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Authorization", "Basic " + encoded);
            con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            con.setRequestProperty("Content-Type", "application/json; charset=uft-8");

            Gson gson = new Gson();

            String json = gson.toJson(payload);

            OutputStream os = con.getOutputStream();
            os.write(json.getBytes());
            os.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                content.append(line);
            }

            return gson.fromJson(content.toString(), typeToGet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        return null;
    }

    public CarMap carMap(String guididx, int cabinNumber) {
        String routeUrl = "https://" + host + "/car_map/ru/" + guididx + "/" + cabinNumber;

        CarMap carMap = get(routeUrl, authStr, CarMap.class);

        assert carMap != null;

        return carMap;
    }

    public Invoice bill(String guididx, byte cabinNumber, Collection<CabinSeat> seats, BillRequest billRequest) {
        String seatsString = "";

        Iterator<CabinSeat> seatIterator = seats.iterator();
        for (byte i = 0; i < seats.size(); i++) {
            seatsString += seatIterator.next().getSeat();
            if (i < seats.size() - 1) {
                seatsString += ",";
            }
        }

        String routeUrl = "https://" + host + "/bill/ru/" + guididx + "/" + cabinNumber + "/" + seatsString;

        Invoice invoice = post(routeUrl, authStr, billRequest, Invoice.class);

        assert invoice != null;

        return invoice;
    }
}
