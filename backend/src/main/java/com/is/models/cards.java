/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.models;

/**
 *
 * @author drago
 */
public class cards {
    int id,attack,defense,card_set_id,healing,get_less_damage,attack_all_enemies,duplicate_damage_less_defense;
    String name, description,image;
    boolean return_damage,divide_damage,invert_basic_attributes;

    public cards(int id, int attack, int defense, int card_set_id, int healing, int get_less_damage, int attack_all_enemies, int duplicate_damage_less_defense, String name, String description, String image, boolean return_damage, boolean divide_damage, boolean invert_basic_attributes) {
        this.id = id;
        this.attack = attack;
        this.defense = defense;
        this.card_set_id = card_set_id;
        this.healing = healing;
        this.get_less_damage = get_less_damage;
        this.attack_all_enemies = attack_all_enemies;
        this.duplicate_damage_less_defense = duplicate_damage_less_defense;
        this.name = name;
        this.description = description;
        this.image = image;
        this.return_damage = return_damage;
        this.divide_damage = divide_damage;
        this.invert_basic_attributes = invert_basic_attributes;
    }

    public int getId() {
        return id;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getCard_set_id() {
        return card_set_id;
    }

    public int getHealing() {
        return healing;
    }

    public int getGet_less_damage() {
        return get_less_damage;
    }

    public int getAttack_all_enemies() {
        return attack_all_enemies;
    }

    public int getDuplicate_damage_less_defense() {
        return duplicate_damage_less_defense;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public boolean isReturn_damage() {
        return return_damage;
    }

    public boolean isDivide_damage() {
        return divide_damage;
    }

    public boolean isInvert_basic_attributes() {
        return invert_basic_attributes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setCard_set_id(int card_set_id) {
        this.card_set_id = card_set_id;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public void setGet_less_damage(int get_less_damage) {
        this.get_less_damage = get_less_damage;
    }

    public void setAttack_all_enemies(int attack_all_enemies) {
        this.attack_all_enemies = attack_all_enemies;
    }

    public void setDuplicate_damage_less_defense(int duplicate_damage_less_defense) {
        this.duplicate_damage_less_defense = duplicate_damage_less_defense;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setReturn_damage(boolean return_damage) {
        this.return_damage = return_damage;
    }

    public void setDivide_damage(boolean divide_damage) {
        this.divide_damage = divide_damage;
    }

    public void setInvert_basic_attributes(boolean invert_basic_attributes) {
        this.invert_basic_attributes = invert_basic_attributes;
    }
    
    
    
    
    
}
