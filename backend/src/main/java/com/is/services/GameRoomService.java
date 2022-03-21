/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.services;

import com.is.database.repositories.GameRoomQueries;
import com.is.database.repositories.UserGameRoomQueries;
import com.is.models.Game_room;
import com.is.models.User;
import com.is.models.UserRoom;
import com.is.models.response.GameRoomResponse;
import com.is.models.response.UserResponse;
import com.is.utils.game_room.UtilsMethods;
import java.nio.charset.Charset;
import java.util.Random;

/**
 *
 * @author drago
 */

public class GameRoomService {

    private GameRoomQueries gameroomq = new GameRoomQueries();
    private UserGameRoomQueries usergameroomq = new UserGameRoomQueries();

    public String CreateRoom(String obj) {

        UtilsMethods utils = new UtilsMethods();
        Game_room game_room = utils.jsonToGame_room(obj);
        GameRoomResponse gameRoomResponse = new GameRoomResponse();

        String idGameRoom;
        boolean existsId;

        do {
            idGameRoom = utils.getRandomId();
            existsId = gameroomq.existsId(idGameRoom);
        } while (existsId);

        try {
            game_room.setId(idGameRoom);
            gameroomq.create(game_room.getId(), game_room.getName(), game_room.getCard_set_id(), game_room.getStatus());
            usergameroomq.create(game_room.getUser_id(), game_room.getId(), true);

            gameRoomResponse.setGame_room(game_room);
            utils.responseOk(gameRoomResponse);
        } catch (Exception e) {
            utils.responseInternalServerError(gameRoomResponse);
        }

        return utils.convertToJson(gameRoomResponse);

    }

    public void JoinRoom(String obj) {

        UtilsMethods utils = new UtilsMethods();
        UserRoom userRoom = utils.jsonToUserRoom(obj);
        GameRoomResponse gameRoomResponse = new GameRoomResponse();

        try {
            usergameroomq.create(userRoom.getUser_id(), userRoom.getGame_room_id(), false);
            //utils.responseOk(gameRoomResponse);
        } catch (Exception e) {
            utils.responseInternalServerError(gameRoomResponse);
        }
    }

    public String RoomList() {
        UtilsMethods utils = new UtilsMethods();
        //Game_room game_room = utils.jsonToGame_room(obj);
        GameRoomResponse gameRoomResponse = new GameRoomResponse();
        
        try {
            gameRoomResponse.setGame_room2(gameroomq.RoomList());
            utils.responseOk(gameRoomResponse);
            
        } catch (Exception e) {
            utils.responseInternalServerError(gameRoomResponse);
        }

        return utils.convertToJson(gameRoomResponse);

    }
}
