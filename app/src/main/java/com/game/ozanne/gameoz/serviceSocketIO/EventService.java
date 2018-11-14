package com.game.ozanne.gameoz.serviceSocketIO;


import java.net.URISyntaxException;

/**
 * Service Layer that connect/disconnectto the serveur and
 * send and receives events too
 */
public interface EventService {


    void connect(String userName) throws URISyntaxException;

    void disconnect();

    void setEventListener(EventListener eventListener);


}
