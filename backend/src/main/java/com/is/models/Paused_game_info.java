/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.models;

/**
 *
 * @author drago
 */
public class Paused_game_info {
    int status;
    String game_room_id;

    public Paused_game_info(int status,String game_room_id) {
        this.status = status;
        this.game_room_id = game_room_id;
    }

    public String getGame_room_id() {
        return game_room_id;
    }

    public void setGame_room_id(String game_room_id) {
        this.game_room_id = game_room_id;
    }
    
    public Paused_game_info(){
        this.status = 1;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
