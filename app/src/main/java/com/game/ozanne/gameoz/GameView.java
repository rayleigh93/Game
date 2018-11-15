package com.game.ozanne.gameoz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.game.ozanne.gameoz.serviceSocketIO.EventListener;
import com.game.ozanne.gameoz.serviceSocketIO.EventServiceImpl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameView extends AppCompatActivity implements EventListener {

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

    List<LinearLayout> linearLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);
        EventServiceImpl.getInstance().setEventListener(this);


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
        String json = args[0].toString();
        Gson gson = new Gson();
        final GameObject gameObject = gson.fromJson(json, GameObject.class);
        Log.i("TYTY", gameObject.toString());

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI
                changeGrille(gameObject);
            }
        });



    }



    public void changeGrille(GameObject gameObject){
        for(int i = 0; i<linearLayouts.size();i++)
        {
            switch (gameObject.arrayCase.get(i).typeCase)
            {
                case "vide" :
                    linearLayouts.get(i).setBackgroundColor(Color.GRAY);
                    break;
                case "green" :
                    linearLayouts.get(i).setBackgroundColor(Color.GREEN);
                    break;
                case "red" :
                    linearLayouts.get(i).setBackgroundColor(Color.RED);
                    break;
                default:
                    break;
            }
        }
    }









}
