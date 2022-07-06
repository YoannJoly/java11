package fr.yoann.api_json;


import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {

    public static void main(String[] args) throws IOException, JSONException {
//        getWeather("Montpellier");
        String JsonString = String.valueOf(getWeather("Montpellier"));
        System.out.println("\nJSON: " + JsonString);
        JSONObject jsonObject = new JSONObject(JsonString);
        System.out.println("\nVille: " + jsonObject.getString("name"));
        JSONArray jsonArray = jsonObject.getJSONArray("weather");
        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
        System.out.println("\nTemps: " + jsonObject1.getString("main"));

        System.out.println("\nSpaceX: " + getSpaceXAPI());
    }

    private static @NotNull StringBuffer getStringBuffer(final @NotNull URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        System.out.println("\nStatus: " + status);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        return content;
    }

    public static @NotNull StringBuffer getWeather(String city) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=66a83085402dd14a6bd76795c3f0d398");
        return getStringBuffer(url);
    }

    public static @NotNull StringBuffer getSpaceXAPI() throws IOException {
        URL url = new URL("https://api.spacexdata.com/v4/launches/latest");
        return getStringBuffer(url);
    }
}