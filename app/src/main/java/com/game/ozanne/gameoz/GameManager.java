package com.game.ozanne.gameoz;

import android.graphics.Color;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private List<LinearLayout> linearLayoutList;



    public GameManager(List<LinearLayout> linearLayoutList) {
        this.linearLayoutList = linearLayoutList;
    }




















    public List<LinearLayout> getLinearLayoutList() {
        return linearLayoutList;
    }

    public void setLinearLayoutList(List<LinearLayout> linearLayoutList) {
        this.linearLayoutList = linearLayoutList;
    }



}
