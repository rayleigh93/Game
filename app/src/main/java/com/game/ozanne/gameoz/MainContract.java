package com.game.ozanne.gameoz;

import com.game.ozanne.gameoz.serviceSocketIO.EventListener;

public interface MainContract {


    interface View extends BaseView<Presenter>, EventListener {

        // Update UI to show the message has been delivered

    }

    interface Presenter extends BasePresenter, EventListener {


        // Action à envoyé

    }


}
