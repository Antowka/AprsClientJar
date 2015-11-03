package ru.antowka.aprs.job;

import ru.antowka.aprs.model.AprsClient;
import ru.antowka.aprs.model.AprsWeather;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by Anton Nikanorov on 26.10.15.
 */
public class sendAprsPosition {

    private List<AprsClient> aprsClients;

    private List<AprsWeather> aprsWheather;

    private int portNumber;

    private String hostName;


    public void send(){

        //Send APRS users
        aprsClients.stream().forEach(this::sendObjectToAPRS);

        try {
            Thread.sleep(10000);                 //10 sec
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        //send WX-stations
        aprsWheather.stream().forEach(wx -> {

            String weatherlink = wx.getLink();

            //todo - make parse weather by link

            sendObjectToAPRS(wx);
        });
    }

    /**
     * Method send APRS object to APRS-server
     *
     * @param client
     */
    private void sendObjectToAPRS(AprsClient client){

        try {

            Socket sock = new Socket(hostName, portNumber);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream());

            //Send Auth
            System.out.println("Start send client: " + client.getCallsign());
            out.println(client.getAuthString());
            out.flush();

            try {
                Thread.sleep(3000);                 //3 sec
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            //read response
            System.out.println("Response on AUTH:");
            System.out.println(in.readLine());

            //send message to aprs
            out.println(client.toString());
            out.flush();

            //read response
            System.out.println("Response on MSG:");
            System.out.println(in.readLine());

            //close socket
            try {

                in.close();
                out.close();
                sock.close();

            } catch (IOException e) {
                System.out.println("Can't close socket!!!");
            }

        } catch (IOException e) {
            System.out.println("Socket is fail!!!");
        }
    }


    /**
     *
     * ********************** SETTERS and GETTERS *****************************
     *
     */


    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setAprsClients(List<AprsClient> aprsClients) {
        this.aprsClients = aprsClients;
    }

    public void setAprsWheather(List<AprsWeather> aprsWheather) {
        this.aprsWheather = aprsWheather;
    }
}
