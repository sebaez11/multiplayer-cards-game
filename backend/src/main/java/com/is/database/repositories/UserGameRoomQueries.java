/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.database.repositories;

import com.is.database.Database;
import com.is.models.Game_room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drago
 */
public class UserGameRoomQueries {
    
    public Boolean create(int user_id, String game_room_id, boolean is_host){
        
        PreparedStatement pstatement = null;
        int resultSet = 0;
        Boolean user_game_room_created = false;
        String sql = "INSERT INTO users_game_room (user_id, game_room_id, is_host) VALUES"
                + "('" + user_id  + "','" + game_room_id + "','" + is_host +"')";
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeUpdate();
            
            if(resultSet > 0){
                user_game_room_created = true;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(Game_room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user_game_room_created;
    }
}
