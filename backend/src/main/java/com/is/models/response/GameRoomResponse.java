/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.models.response;

import com.is.models.Game_room;
import com.is.utils.Status;
import java.util.Collection;

/**
 *
 * @author drago
 */
public class GameRoomResponse {
        
    private Status status;
    private Game_room game_room;
    private Collection<Game_room> Game_room;

    public GameRoomResponse() {
        this.status = new Status();
    }
    
    public Status getStatus() {
        return status;
    }

    public Game_room getGame_room() {
        return game_room;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setGame_room(Game_room game_room) {
        this.game_room = game_room;
    }

    public void setGame_room2(Collection<Game_room> Game_room) {
        this.Game_room = Game_room;
    }
    public Collection<Game_room> getGame_Room(){
        return Game_room;
    }

    
}
