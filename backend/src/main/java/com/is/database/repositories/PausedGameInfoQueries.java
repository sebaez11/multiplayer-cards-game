/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.database.repositories;

import com.is.database.Database;
import com.is.models.Paused_game_info;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drago
 */
public class PausedGameInfoQueries {
    
    public int ActualStatus(String game_room_id){
        
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT status FROM game_room u WHERE u.id = '" + game_room_id + "'";
        Paused_game_info paused_game_info= new Paused_game_info();
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            
            if(resultSet != null){
                return resultSet.getInt(1);
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(Paused_game_info.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
    
    public Boolean UpgradeStatus(String game_room_id,int status){
        
        PreparedStatement pstatement = null;
        int resultSet = 0;
        Boolean user_game_room_created = false;
        String sql = "UPDATE game_room SET status='"+status+" WHERE id='"+game_room_id+"'";
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeUpdate();
            
            if(resultSet > 0){
                user_game_room_created = true;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(Paused_game_info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user_game_room_created;
    }
    
}
