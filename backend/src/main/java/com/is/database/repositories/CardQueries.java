/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.database.repositories;

import com.is.database.Database;
import com.is.models.Card;
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
public class CardQueries {
    
    
    public Boolean create(String name, int attack, int defense,String description, 
            String image,int card_set_id,String healing,int get_less_damage, int attack_all_enemies, 
            boolean return_damage,boolean divide_damage,int duplicate_damage_less_defense, boolean invert_basic_attributes){
        
    
        PreparedStatement pstatement = null;
        int resultSet = 0;
        Boolean card_created = false;
        String sql = "INSERT INTO cards (name, attack, defense, description, image, card_set_id, healing, "
                + "get_less_damage, attack_all_enemies, return_damage, divide_damage, duplicate_damage_less_defense, "
                + "invert_basic_attributes) VALUES('" + name + "','" + attack + "','" + defense + "','" + description + 
                "','"+image+"','"+card_set_id+"','"+healing+"','"+get_less_damage+"','"+attack_all_enemies+"','"+return_damage+
                "','"+divide_damage+"','"+duplicate_damage_less_defense+"','"+invert_basic_attributes+"')";
        
        Card card = new Card();
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeUpdate();
            
            if(resultSet > 0){
                card_created = true;
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return card_created;
    }
    
}
