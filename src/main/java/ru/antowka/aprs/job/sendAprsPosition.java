package ru.antowka.aprs.job;

import ru.antowka.aprs.model.AprsClient;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by Anton Nikanorov on 26.10.15.
 */
public class sendAprsPosition {

    private List<AprsClient> aprsClients;

    private int portNumber;

    private String hostName;


    public void send(){

            aprsClients.stream().forEach(client -> {

                System.out.println("Start send client: " + client.getCallsign());

                String auth = "user " + client.getCallsign() + " pass " + client.getPass() + "\n";

                try {

                    Socket sock = new Socket(hostName, portNumber);
                    BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    PrintWriter out = new PrintWriter(sock.getOutputStream());

                    //Send Auth
                    out.println(auth);
                    out.flush();

                    try {
                        Thread.sleep(3000);                 //3 sec
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    //read response
                    System.out.println("Response on AUTH:");
                    System.out.println(in.readLine());

                    String msg =    client.getCallsign()
                                    + ">APRS:!"
                                    + client.getLatitude()
                                    + "/0"
                                    + client.getLongitude()
                                    + client.getIco()
                                    + ""
                                    + client.getMessage()
                                    + "\n";

                    //send message to aprs
                    out.println(msg);
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
            });
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
}
