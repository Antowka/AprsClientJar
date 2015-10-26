package ru.antowka.aprs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Anton Nik on 26.10.15.
 */
public class Initializer {

    public static void main(String [] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
                "config/main-config.xml",
                "config/quartz-config.xml",
                "config/aprs-clients.xml"
        });
    }
}
