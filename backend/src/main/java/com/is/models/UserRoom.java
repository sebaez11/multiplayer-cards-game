/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.models;

/**
 *
 * @author drago
 */
public class UserRoom {
    int user_id;
    String game_room_id;

    public UserRoom(int user_id, String game_room_id) {
        this.user_id = user_id;
        this.game_room_id = game_room_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getGame_room_id() {
        return game_room_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setGame_room_id(String game_room_id) {
        this.game_room_id = game_room_id;
    }
    
}
