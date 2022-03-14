/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.utils.users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.is.models.response.UserResponse;
import com.is .models.User;
import com.is.utils.Constants;

/**
 *
 * @author sebastian-dev
 */
public class UtilsMethods {
    
    public void responseOk(UserResponse userResponse) {
	userResponse.getStatus().setStatusCode(201);
	userResponse.getStatus().setStatusDescription(Constants.SUCCESS_MESSAGE);
	userResponse.getStatus().setSeverity(Constants.SEVERITY_INFO);
    }
    
    public void responseBadRequest(UserResponse userResponse) {
	userResponse.getStatus().setStatusCode(400);
	userResponse.getStatus().setStatusDescription(Constants.BAD_REQUEST_MESSAGE);
	userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
    }
    
    public void responseInvalidEmail(UserResponse userResponse){
        userResponse.getStatus().setStatusCode(400);
	userResponse.getStatus().setStatusDescription(Constants.INVALID_EMAIL_MESSAGE);
	userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
    }
    
    public void responseInvalidUsername(UserResponse userResponse){
        userResponse.getStatus().setStatusCode(400);
	userResponse.getStatus().setStatusDescription(Constants.INVALID_USERNAME_MESSAGE);
	userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
    }
    
    public void responseInvalidPassword(UserResponse userResponse){
        userResponse.getStatus().setStatusCode(400);
	userResponse.getStatus().setStatusDescription(Constants.INVALID_PASSWORD_MESSAGE);
	userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
    }
    
    public void responseUserNotFound(UserResponse userResponse) {
	userResponse.getStatus().setStatusCode(400);
	userResponse.getStatus().setStatusDescription(Constants.USER_NOT_FOUND_MESSAGE);
	userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);
    }
    
    public void responseInternalServerError(UserResponse userResponse) {		
	userResponse.getStatus().setStatusCode(500);
	userResponse.getStatus().setStatusDescription(Constants.INTERNAL_SERVER_ERROR_MESSAGE);
	userResponse.getStatus().setSeverity(Constants.SEVERITY_ERROR);	
    }
    
    public User jsonToUser(String json){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        User user = gson.fromJson(json,User.class);
        
        return user;
    }
    
    public String convertToJson(UserResponse userResponse){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        return gson.toJson(userResponse);
    }
    
}
