package com.game.ozanne.gameoz.MainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.game.ozanne.gameoz.GameView;
import com.game.ozanne.gameoz.R;
import com.game.ozanne.gameoz.remoteDataSource.RemoteDataSource;
import com.game.ozanne.gameoz.repository.Repository;

import java.net.URISyntaxException;

public class MainView extends AppCompatActivity implements MainContract.View {


    private MainContract.Presenter mPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            mPresenter = new MainPresenter(Repository.getInstance
                    (RemoteDataSource.getInstance(),RemoteDataSource.getInstance())
                    ,this,
                            this);

        try {
            mPresenter.subscribe();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }



        startActivity(new Intent(this,GameView.class));

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void setPresenter(MainContract.Presenter presenter) {
                mPresenter = presenter;
    }

    @Override
    public void initView() {

    }



    @Override
    public void onConnect(Object... args) {
        Log.i("TOTO","OK TOTO");
    }

    @Override
    public void onDisconnect(Object... args) {

    }

    @Override
    public void onUserJoined(Object... args) {

    }

    @Override
    public void onGameCreated(Object... args) {

    }


}
