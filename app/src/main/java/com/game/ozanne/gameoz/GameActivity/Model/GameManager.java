package com.game.ozanne.gameoz.GameActivity.Model;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.game.ozanne.gameoz.GameActivity.ClickOnCase;
import com.game.ozanne.gameoz.GameActivity.Model.POJO.GameObject;
import com.game.ozanne.gameoz.serviceSocketIO.EventServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements View.OnClickListener {

    private List<LinearLayout> linearLayoutList  ;
    private static final String TYPE_CASE_VIDE ="vide";
    private static final String TYPE_CASE_GREEN ="green";
    private static final String TYPE_CASE_RED ="red";
    private ClickOnCase mClickOnCaseListener;
    @NonNull
    private GameObject mGameObject;

    public GameManager(List<LinearLayout> linearLayoutList, ClickOnCase clickOnCaseListener) {
        this.linearLayoutList = linearLayoutList;
        this.mClickOnCaseListener = clickOnCaseListener;
        mGameObject = new GameObject();
        initListenerGrille();


    }

    public void changeGrille(GameObject gameObject){
        for(int i = 0; i<linearLayoutList.size();i++)
        {
            switch (gameObject.arrayCase.get(i).typeCase)
            {
                case TYPE_CASE_VIDE :
                    linearLayoutList.get(i).setBackgroundColor(Color.GRAY);
                    break;
                case TYPE_CASE_GREEN :
                    linearLayoutList.get(i).setBackgroundColor(Color.GREEN);
                    break;
                case TYPE_CASE_RED :
                    linearLayoutList.get(i).setBackgroundColor(Color.RED);
                    break;
                default:
                    break;
            }
        }
        this.mGameObject = gameObject;
    }

    public void initListenerGrille(){
        for(int i = 0;i<linearLayoutList.size();i++)
            linearLayoutList.get(i).setOnClickListener(this);
    }
    
    

    @Override
    public void onClick(View v) {

        if(!EventServiceImpl.getmSocket().id().isEmpty() && !mGameObject.playerTurn.isEmpty()) {
            for (LinearLayout linearLayout : linearLayoutList) {
                if (linearLayout.equals(v) &&
                        mGameObject.playerTurn.equals(EventServiceImpl.getmSocket().id())) {
                    mClickOnCaseListener.clickOnCase(linearLayoutList.indexOf(linearLayout));
                }
            }
        }



    }
    }
    
    
    

