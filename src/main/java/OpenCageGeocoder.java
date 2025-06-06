import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;

/**
 * Geocoder using the OpenCage API.
 * Retrieves the country code for a city. The country code is returned in lowercase.
 */
public class OpenCageGeocoder {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("GEO_API_KEY");

    public static String getCountryCode(String city) throws Exception {
        String encodedCity = URLEncoder.encode(city, "UTF-8");
        String urlString = "https://api.opencagedata.com/geocode/v1/json?q="
                + encodedCity + "&key=" + API_KEY + "&limit=1";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP GET Request Failed with Error code : " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonObject = new JSONObject(response.toString());
        if (jsonObject.getJSONArray("results").length() > 0) {
            JSONObject firstResult = jsonObject.getJSONArray("results").getJSONObject(0);
            return firstResult.getJSONObject("components").getString("country_code").toLowerCase();
        }

        return null;
    }
}