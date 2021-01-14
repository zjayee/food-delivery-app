package com.example.goa_project3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant implements Serializable {
    private String name;
    private String cuisine;
    private Integer image;
    private HashMap<String, ArrayList<Dish>> menu;
    private float rating;

    public Restaurant(String name, String cuisine, Integer image, HashMap<String, ArrayList<Dish>> menu, float rating ){
        this.name = name;
        this.cuisine = cuisine;
        this.image = image;
        this.menu = menu;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public Integer getImage() {
        return image;
    }

    public HashMap<String,ArrayList<Dish>> getMenu(){
        return menu;
    }

    public float getRating() {
        return rating;
    }
}
