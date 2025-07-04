import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.json.JSONObject;
import io.github.cdimascio.dotenv.Dotenv;

/*
 * Implementation of the weather service that uses the OpenWeatherMap API and OpenCageGeocoder.
 * Implements the WeatherService interface.
 */
public class WeatherAPI implements WeatherService {
    private final Dotenv dotenv = Dotenv.load();
    private final String apiKey = dotenv.get("WEATHER_API_KEY");

    /*
     * Retrieves current weather data for the specified city.
     *
     */
    @Override
    public WeatherData getCurrentWeather(String city) throws WeatherException {
        try {
            String urlString = "http://api.openweathermap.org/data/2.5/weather?q="
                    + city + "," + OpenCageGeocoder.getCountryCode(city)
                    + "&APPID=" + apiKey;
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if(responseCode != 200) {
                throw new WeatherException("Error retrieving weather data. HTTP code: " + responseCode);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObj = new JSONObject(response.toString());
            CurrentWeather weather = new CurrentWeather();
            weather.setCity(city);
            weather.setTemperature(jsonObj.getJSONObject("main").getDouble("temp"));
            weather.setDescription(jsonObj.getJSONArray("weather").getJSONObject(0).getString("description"));
            weather.setHumidity(jsonObj.getJSONObject("main").getInt("humidity"));
            weather.setWindSpeed(jsonObj.getJSONObject("wind").getDouble("speed"));

            // Extract the timezone offset from the API response
            int timezoneOffsetSeconds = jsonObj.getInt("timezone");

            // Calculate the local time based on the timezone offset
            Instant nowUtc = Instant.now();
            ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(timezoneOffsetSeconds);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(nowUtc, zoneOffset);
            String formattedTime = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            weather.setLocalTime(formattedTime);

            return weather;
        } catch (Exception e) {
            throw new WeatherException("An error occurred while retrieving data: " + e.getMessage(), e);
        }
    }
}