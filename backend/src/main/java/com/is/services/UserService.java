/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.services;

import com.is.database.repositories.UserQueries;
import com.is.models.User;
import com.is.models.response.UserResponse;
import com.is.utils.users.UtilsMethods;

/**
 *
 * @author sebastian-dev
 */
public class UserService {
    
    private UserQueries userq = new UserQueries();
    
    public String Signup(String obj){
        
        
        UtilsMethods utils = new UtilsMethods();
        User user = utils.jsonToUser(obj);
        UserResponse userResponse = new UserResponse();
        
        boolean userExistsByEmail = userq.existsByEmail(user.getEmail());
        boolean userExistsByUsername = userq.existsByUsername(user.getUsername());
        
        /*if(!userExistsByEmail){
            if(!userExistsByUsername){
                try {
                        user.setRole_id(1);
                        userq.create(user.getUsername(), user.getEmail(), user.getPassword());
                        userResponse.setUser(user);
                }catch(Exception e){
                    utils.responseInternalServerError(userResponse);
                }
            }else {
                utils.responseInvalidUsername(userResponse);
            }
            
        }else {
            utils.responseInvalidEmail(userResponse);
        }*/
        
        
        
        return utils.convertToJson(user);
        
    }
    
}
