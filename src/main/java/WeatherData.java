import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Abstract class containing common properties for weather data.
 *
 * This project is implemented following good object-oriented programming principles,
 * including encapsulation, SOLID principles, and appropriate use of inheritance and polymorphism.
 */
public abstract class WeatherData implements Serializable {
    private String city;
    private double temperature;
    private String description;
    private int humidity;
    private double windSpeed;
    private String localTime;

    // Field to store the date when data is recorded
    private Date recordDate;

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public double getTemperatureInC() {
        return Math.round(temperature - 273.15);
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public int getHumidity() {
        return humidity;
    }

    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }
    public double getWindSpeed(){
        return windSpeed;
    }

    public String getLocalTime() {
        return localTime;
    }
    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public Date getRecordDate() {
        return recordDate;
    }
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    // Helper method to format the record date as a string
    protected String getFormattedRecordDate() {
        if(recordDate == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(recordDate);
    }

    // Abstract method to return the weather data as a string
    public abstract String display();
}