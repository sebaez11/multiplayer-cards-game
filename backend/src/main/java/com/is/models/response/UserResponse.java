/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.models.response;

import com.is.utils.Status;
import com.is.models.User;

/**
 *
 * @author sebastian-dev
 */
public class UserResponse {
    
    private Status status;
    private User user;
    
    public UserResponse() {
        this.status = new Status();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
