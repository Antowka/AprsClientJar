package ru.antowka.aprs.model.dto.weather;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by anton on 07.01.17.
 */
@XmlRootElement(name = "current")
public class Current {
    private City city;
    private Temperature temperature;
    private Humidity humidity;
    private Pressure pressure;

    public City getCity() {
        return city;
    }

    @XmlElement
    public void setCity(City city) {
        this.city = city;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    @XmlElement
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    @XmlElement
    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Pressure getPressure() {
        return pressure;
    }

    @XmlElement
    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }
}
