package ru.antowka.aprs.model.dto.weather;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by anton on 07.01.17.
 */
@XmlType(name = "temperature")
public class Temperature {
    private float value;
    private float min;
    private float max;
    private String unit;

    public float getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(float value) {
        this.value = value;
    }

    public float getMin() {
        return min;
    }

    @XmlAttribute
    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    @XmlAttribute
    public void setMax(float max) {
        this.max = max;
    }

    public String getUnit() {
        return unit;
    }

    @XmlAttribute
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
