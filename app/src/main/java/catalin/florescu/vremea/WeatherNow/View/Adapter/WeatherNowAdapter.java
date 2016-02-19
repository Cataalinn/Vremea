package catalin.florescu.vremea.WeatherNow.View.Adapter;

/**
 * Created by Florescu George Cătălin on 24.10.2015.
 */
public class WeatherNowAdapter {

    private String place, temperature, maxTemperature, minTemperature, pressure, humidity, altitude, wind, description;

    public WeatherNowAdapter(String place, String temperature, String maxTemperature, String minTemperature, String pressure, String humidity, String altitude,
                             String wind, String description) {
        this.place = place;
        this.temperature = temperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.altitude = altitude;
        this.description = description;
        this.wind = wind;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
