package com.game.ozanne.gameoz.MainActivity;

import com.game.ozanne.gameoz.serviceSocketIO.EventListener;

public interface MainContract {

    interface View extends BaseView<Presenter>, EventListener {


    }

    interface Presenter extends BasePresenter, EventListener {


    }



}
