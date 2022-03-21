/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.utils.game_room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.is.models.Game_room;
import com.is.models.Paused_game_info;
import com.is.models.UserRoom;
import com.is.models.response.GameRoomResponse;
import com.is.models.Paused_game_info;
import com.is.utils.Constants;
import java.nio.charset.Charset;
import java.util.Random;

/**
 *
 * @author drago
 */
public class UtilsMethods {

    public void responseOk(GameRoomResponse gameRoomResponse) {
        gameRoomResponse.getStatus().setStatusCode(201);
        gameRoomResponse.getStatus().setStatusDescription(Constants.SUCCESS_MESSAGE);
        gameRoomResponse.getStatus().setSeverity(Constants.SEVERITY_INFO);
    }

    public void responseBadRequest(GameRoomResponse gameRoomResponse) {
        gameRoomResponse.getStatus().setStatusCode(400);
        gameRoomResponse.getStatus().setStatusDescription(Constants.BAD_REQUEST);
        gameRoomResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
    }

    public void responseInternalServerError(GameRoomResponse gameRoomResponse) {
        gameRoomResponse.getStatus().setStatusCode(500);
        gameRoomResponse.getStatus().setStatusDescription(Constants.INTERNAL_SERVER_ERROR_MESSAGE);
        gameRoomResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
    }

    public Game_room jsonToGame_room(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Game_room game_room = gson.fromJson(json, Game_room.class);

        return game_room;
    }
     public Paused_game_info jsonToPaused_game_info(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Paused_game_info paused_game_info = gson.fromJson(json, Paused_game_info.class);
        return paused_game_info;
    }


    public UserRoom jsonToUserRoom(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UserRoom userRoom = gson.fromJson(json, UserRoom.class);

        return userRoom;
    }

    public String convertToJson(GameRoomResponse gameRoomResponse) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        return gson.toJson(gameRoomResponse);
    }

    public String getRandomId() {

        // bind the length
        byte[] bytearray = new byte[256];
        String mystring;
        StringBuffer thebuffer;
        String theAlphaNumericS;

        new Random().nextBytes(bytearray);

        mystring
                = new String(bytearray, Charset.forName("UTF-8"));

        thebuffer = new StringBuffer();

        //remove all spacial char 
        theAlphaNumericS = mystring.replaceAll("[^A-Z0-9]", "");
        int i = 5;
        //random selection
        for (int m = 0; m < theAlphaNumericS.length(); m++) {

            if (Character.isLetter(theAlphaNumericS.charAt(m))
                    && (i > 0)
                    || Character.isDigit(theAlphaNumericS.charAt(m))
                    && (i > 0)) {

                thebuffer.append(theAlphaNumericS.charAt(m));
                i--;
            }
        }

        // the resulting string 
        return thebuffer.toString();
    }

}
