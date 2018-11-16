package com.game.ozanne.gameoz.GameActivity.Model.POJO;


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public  class GameObject {


    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("playerTurn")
    public String playerTurn;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("idUserOne")
    public String idUserOne;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("idUserTwo")
    public String idUserTwo;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("arrayCase")
    public List<ArrayCase> arrayCase;


    public GameObject() {
        playerTurn = "";
        idUserOne = "";
        idUserTwo = "";
        arrayCase = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "GameObject{" +
                "playerTurn='" + playerTurn + '\'' +
                ", idUserOne='" + idUserOne + '\'' +
                ", idUserTwo='" + idUserTwo + '\'' +
                ", arrayCase=" + arrayCase +
                '}';
    }
}
