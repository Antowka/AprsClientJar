package ru.antowka.aprs.model;

import ru.antowka.aprs.model.dto.weather.Current;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

        DateFormat df = new SimpleDateFormat("ddHHmm");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        return getCallsign()
                + ">APRS,TCPIP*:@"
                + df.format(new Date())
                + "z"
                + getLatitude()
                + "/0"
                + getLongitude()
                + "_.../..."
                + "g..."
                + "t0" + ((int)weather.getTemperature().getValue())
                + "h" + ((int)weather.getHumidity().getValue())
                + "b" + (Integer.valueOf(weather.getPressure().getValue().replaceAll("\\..+", ""))) + "0";
    }
}
