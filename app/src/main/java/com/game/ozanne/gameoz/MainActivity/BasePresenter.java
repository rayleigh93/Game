package com.game.ozanne.gameoz.MainActivity;

import java.net.URISyntaxException;

interface BasePresenter {


    void unsubscribe();

    void subscribe(String userName) throws URISyntaxException;

}
