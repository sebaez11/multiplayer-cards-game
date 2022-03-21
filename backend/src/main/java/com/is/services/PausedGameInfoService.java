/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.services;

import com.is.models.Paused_game_info;
import com.is.database.repositories.PausedGameInfoQueries;
import com.is.database.repositories.GameRoomQueries;
import com.is.models.Game_room;
import com.is.models.response.GameRoomResponse;
import com.is.utils.game_room.UtilsMethods;

/**
 *
 * @author drago
 */
public class PausedGameInfoService {

    public String ResponseStatus(String obj) {

        UtilsMethods utils = new UtilsMethods();

        Paused_game_info paused_game_info = utils.jsonToPaused_game_info(obj);

        Paused_game_info paused_game_Response = new Paused_game_info();

        GameRoomQueries gameRoomQueries = new GameRoomQueries();
        GameRoomResponse gameRoomResponse = new GameRoomResponse();
        PausedGameInfoQueries pausedgameq = new PausedGameInfoQueries();
        int status;

        status = pausedgameq.ActualStatus(paused_game_info.getGame_room_id());

        try {
            if (status == 1) {
                pausedgameq.UpgradeStatus(paused_game_info.getGame_room_id(), 2);
            }
            if (status == 2) {
                pausedgameq.UpgradeStatus(paused_game_info.getGame_room_id(), 1);
            }
            if (status == 3) {
                gameRoomQueries.DeleteGameRoom(paused_game_info.getGame_room_id());
            }
            
            paused_game_Response.setStatus(paused_game_info.getStatus());
            utils.responseOk(gameRoomResponse);
            
        } catch (Exception e) {
            utils.responseInternalServerError(gameRoomResponse);
        }

        return utils.convertToJson(gameRoomResponse);

    }
}
