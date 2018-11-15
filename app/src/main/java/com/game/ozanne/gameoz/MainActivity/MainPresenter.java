package com.game.ozanne.gameoz.MainActivity;

import android.support.annotation.NonNull;

import com.game.ozanne.gameoz.repository.Repository;
import com.game.ozanne.gameoz.serviceSocketIO.EventListener;

import java.net.URISyntaxException;

public class MainPresenter implements MainContract.Presenter {


    @NonNull
    private final Repository mRepository;

    @NonNull
    private final MainContract.View mView;


    @NonNull
    private final EventListener mViewEventListener;



    public MainPresenter(@NonNull Repository mRepository,
                         @NonNull MainContract.View mView,
                         @NonNull EventListener mViewEventListener) {

        this.mRepository = mRepository;
        this.mView = mView;
        this.mViewEventListener = mViewEventListener;

        // Setting the view's eventListener in the repository so that
        // when server sends events to repository, it passes the
        // events to the view
        mRepository.setEventListener(this);





    }



    @Override
    public void subscribe() throws URISyntaxException {
            mRepository.connect("toto");
    }

    @Override
    public void unsubscribe() {

    }


    @Override
    public void onConnect(Object... args) {
        mViewEventListener.onConnect(args);
    }

    @Override
    public void onDisconnect(Object... args) {
        mViewEventListener.onDisconnect(args);
    }

    @Override
    public void onUserJoined(Object... args) {
        mViewEventListener.onUserJoined(args);
    }

    @Override
    public void onGameCreated(Object... args) {
        mViewEventListener.onGameCreated(args);
    }
}
