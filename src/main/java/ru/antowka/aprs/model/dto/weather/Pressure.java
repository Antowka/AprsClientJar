package ru.antowka.aprs.model.dto.weather;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by anton on 07.01.17.
 */
@XmlType(name = "pressure")
public class Pressure {
    private int value;
    private String unit;

    public int getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    @XmlAttribute
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
