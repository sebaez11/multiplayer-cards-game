/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.database.repositories;

import com.is.database.Database;
import com.is.models.card_set;
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
public class CardSetQueries {
    
    public Boolean create(int total_cards, String image, String name){
    
        PreparedStatement pstatement = null;
        int resultSet = 0;
        Boolean card_set_created = false;
        String sql = "INSERT INTO card_set (total_cards, image, name) VALUES('" + total_cards + "','" + image + "','" + name + "')";
        
        card_set Card_set = new card_set();
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeUpdate();
            
            if(resultSet > 0){
                card_set_created = true;
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(card_set.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return card_set_created;
        

    }
}

