/**
 * Class extending WeatherData and adding additional logic for current weather.
 * Demonstrates polymorphism by overriding display().
 */
public class CurrentWeather extends WeatherData {
    @Override
    public String display() {
        return "(" + getFormattedRecordDate() + ") Weather in city " + getCity() + ": "
                + getTemperatureInC() + "°C, " + getDescription() + ", wind speed: " + getWindSpeed()
                + ", humidity: " + getHumidity() + "%";
    }
}