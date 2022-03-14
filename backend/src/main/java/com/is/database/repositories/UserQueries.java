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
    
    public boolean create(String username, String email, String password){
    
        PreparedStatement pstatement = null;
        int resultSet = 0;
        boolean user_created = false;
        String sql = "INSERT INTO users(role_id, username, email, password) VALUES(1,'" + username + "','" + email + "','" + password + "')";
        
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
    
    
    public boolean existsByEmail(String email){
        
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users u WHERE u.email = '" + email + "'";
        
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            
            if(resultSet != null){
                return resultSet.next();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    public boolean existsByUsername(String username){
    
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users u WHERE u.username = '" + username + "'";
        
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            if(resultSet != null){
                return resultSet.next();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
 
    }
    
    public boolean validPassword(String username, String password){
        
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users WHERE username='" + username + "'AND password='"+password+"'";
        
        try {
            Connection conn = Database.getConection();
            pstatement = conn.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            
            if(resultSet != null){
                return resultSet.next();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    
}