/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.models;

/**
 *
 * @author drago
 */
public class Game_room {
    
    String id,name;
    int paused_game_info_id, card_set_id, user_id;
    int status=1;// 1.in game - 2.paused game - 3.finished game 
    
    
    public Game_room(String id, String name, int paused_game_info_id, int card_set_id, int status) {
        this.id = id;
        this.name = name;
        this.paused_game_info_id = paused_game_info_id;
        this.card_set_id = card_set_id;
        this.status = status;

    }
    
    public Game_room(){
        this.id = "";
        this.name = "";
        this.paused_game_info_id = 0;
        this.card_set_id = 0;
        this.status = 1;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPaused_game_info_id() {
        return paused_game_info_id;
    }

    public int getCard_set_id() {
        return card_set_id;
    }

    public int getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPaused_game_info_id(int paused_game_info_id) {
        this.paused_game_info_id = paused_game_info_id;
    }

    public void setCard_set_id(int card_set_id) {
        this.card_set_id = card_set_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
