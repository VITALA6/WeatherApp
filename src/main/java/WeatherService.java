/**
 * Interface for the weather service.
 * Declares a method to retrieve the current weather for a given city.
 */
public interface WeatherService {
    /*
     * Retrieves current weather data for the specified city.
     *
     */
    WeatherData getCurrentWeather(String city) throws WeatherException;
}