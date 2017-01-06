package ru.antowka.aprs.model;

import ru.antowka.aprs.model.dto.weather.Current;

/**
 * Created by Anton Nik on 03.11.15.
 */
public class AprsWeather extends AprsClient {

    private String link;
    private Current weather;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setWeather(Current weather) {
        this.weather = weather;
    }

    public String toString(){
        return getCallsign()
                + ">APRS,TCPXX*,qAX,CWOP-2:="
                + getLatitude()
                + "/"
                + getLongitude()
                + "_.../..."
                + "g019"
                + "t" + weather.getTemperature().getValue()
                + "p" + weather.getPressure().getValue()
                + "h" + weather.getHumidity().getValue()
                + "b10220"
                + "L000"
                + "WX Station";
    }
}
