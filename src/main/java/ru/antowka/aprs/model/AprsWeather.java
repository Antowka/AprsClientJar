package ru.antowka.aprs.model;

import ru.antowka.aprs.model.dto.weather.Current;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        DateFormat df = new SimpleDateFormat("DDssmm");

        return getCallsign()
                + ">APRS,TCPIP*:@"
                + df.format(new Date())
                + "z"
                + getLatitude()
                + "/"
                + getLongitude()
                + "_000/000"
                + "g000"
                + "t" + (int)weather.getTemperature().getValue()
                + "h" + (int)weather.getHumidity().getValue()
                + "b" + weather.getPressure().getValue() + "0"
                + "Virtual WX Station";
    }
}
