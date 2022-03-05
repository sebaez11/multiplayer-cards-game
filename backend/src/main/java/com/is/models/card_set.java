/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.models;


public class card_set {
    int id,total_cards;
    String image,name;

    public card_set(int id, int total_cards, String image, String name) {
        this.id = id;
        this.total_cards = total_cards;
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getTotal_cards() {
        return total_cards;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal_cards(int total_cards) {
        this.total_cards = total_cards;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
