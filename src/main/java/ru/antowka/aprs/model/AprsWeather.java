package ru.antowka.aprs.model;

/**
 * Created by Anton Nik on 03.11.15.
 */
public class AprsWeather extends AprsClient {

    private String temperature;
    private String humidity;
    private String pressure;
    private String wind;
    private String windBlows;
    private String rain;
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWindBlows() {
        return windBlows;
    }

    public void setWindBlows(String windBlows) {
        this.windBlows = windBlows;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String toString(){
        return getCallsign()
                + ">APRS,TCPXX*,qAX,CWOP-2:="
                + getLatitude()
                + "/"
                + getLongitude()
                + "_.../..."
                + "g019"
                + "t058"
                + "r000"
                + "p000"
                + "h65"
                + "b10242"
                + ".wview_5_21_7";
    }
}
