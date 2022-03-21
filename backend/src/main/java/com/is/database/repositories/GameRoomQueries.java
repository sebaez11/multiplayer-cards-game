/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.database.repositories;

import com.is.database.Database;
import com.is.models.Game_room;
import com.is.models.response.GameRoomResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drago
 */
public class GameRoomQueries {
    
    public Boolean create(String id, String name, int card_set_id, int status){
        
    
        PreparedStatement pstatement = null;
        int resultSet = 0;
        Boolean game_room_created = false;
        String sql = "INSERT INTO game_room (id, card_set_id, name, status) VALUES"
                + "('" + id  + "','" + card_set_id + "','" + name + "','" + status +"')";
        
        Game_room game_room = new Game_room();
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeUpdate();
            
            if(resultSet > 0){
                game_room_created = true;
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(Game_room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return game_room_created;
    }
    
    public boolean existsId(String id){
        
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM game_room u WHERE u.id = '" + id + "'";
        
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            
            if(resultSet != null){
                return resultSet.next();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(Game_room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
   public Collection<Game_room> RoomList() {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT * FROM game_room ";

        Vector<Game_room> listado = new Vector<Game_room>();
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            
            
            while (resultSet.next()) {
                Game_room game_room = new Game_room();
                game_room.setId(resultSet.getString(1));
                game_room.setName(resultSet.getString(4));
                game_room.setCard_set_id(resultSet.getInt(3));
                game_room.setStatus(resultSet.getInt(5));
              
                listado.add(game_room);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Game_room.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
}
