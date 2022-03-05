/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.database.repositories;

import com.is.database.Database;
import com.is.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastian-dev
 */
public class UserQueries {
    
    public Boolean create(String username, String email, String password){
    
        PreparedStatement pstatement = null;
        int resultSet = 0;
        Boolean user_created = false;
        String sql = "INSERT INTO users(role_id, username, email, password) VALUES(1,'" + username + "','" + email + "','" + password + "')";
        
        User user = new User();
        
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeUpdate();
            
            if(resultSet > 0){
                user_created = true;
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user_created;
        

    }
    
}