package com.game.ozanne.gameoz.GameActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.game.ozanne.gameoz.GameActivity.Model.GameManager;
import com.game.ozanne.gameoz.GameActivity.Model.POJO.GameObject;
import com.game.ozanne.gameoz.R;
import com.game.ozanne.gameoz.remoteDataSource.RemoteDataSource;
import com.game.ozanne.gameoz.repository.Repository;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameViewGame extends AppCompatActivity implements GameContract.ViewGame {

    @BindView(R.id.caseOne)
    LinearLayout caseOne;
    @BindView(R.id.caseTwo)
    LinearLayout caseTwo;
    @BindView(R.id.caseThree)
    LinearLayout caseThree;
    @BindView(R.id.caseFour)
    LinearLayout caseFour;
    @BindView(R.id.caseFive)
    LinearLayout caseFive;
    @BindView(R.id.caseSix)
    LinearLayout caseSix;
    @BindView(R.id.caseSeven)
    LinearLayout caseSeven;
    @BindView(R.id.caseHeight)
    LinearLayout caseHeight;
    @BindView(R.id.caseNine)
    LinearLayout caseNine;

    private List<LinearLayout> linearLayouts;
    private GameManager gameManager;
    private GameContract.PresenterGame mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mPresenter = new GamePresenterGame(  new Repository(RemoteDataSource.getInstance()
                ,RemoteDataSource.getInstance())
                        ,this,
                        this);

    }


    @Override
    public void onConnect(Object... args) {

    }

    @Override
    public void onDisconnect(Object... args) {

    }

    @Override
    public void onUserJoined(Object... args) {

    }

    @Override
    public void onGameCreated(Object... args) {
        String json = (String) args[0].toString();
        Gson gson = new Gson();
        final GameObject gameObject = gson.fromJson(json, GameObject.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Stuff that updates the UI
                gameManager.changeGrille(gameObject);
            }
        });
    }

    @Override
    public void onNewAction(Object... args) {
        String json = (String) args[0].toString();
        Gson gson = new Gson();
        final GameObject gameObject = gson.fromJson(json, GameObject.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Stuff that updates the UI
                gameManager.changeGrille(gameObject);
            }
        });
    }


    @Override
    public void setPresenter(GameContract.PresenterGame presenter) {
        mPresenter = presenter;
    }

    @Override
    public void initView() {

        ButterKnife.bind(this);

        linearLayouts = new ArrayList<>(9);

        linearLayouts.add(caseOne);
        linearLayouts.add(caseTwo);
        linearLayouts.add(caseThree);

        linearLayouts.add(caseFour);
        linearLayouts.add(caseFive);
        linearLayouts.add(caseSix);

        linearLayouts.add(caseSeven);
        linearLayouts.add(caseHeight);
        linearLayouts.add(caseNine);

        gameManager = new GameManager(linearLayouts,this);
    }

    @Override
    public void clickOnCase(int position) {
        mPresenter.sendAction(position);
        Log.i("TOTO",Integer.toString(position));
    }

    @Override
    public void onActionSend() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Stuff that updates the UI
                Toast.makeText(GameViewGame.this, "ok envoyee", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
