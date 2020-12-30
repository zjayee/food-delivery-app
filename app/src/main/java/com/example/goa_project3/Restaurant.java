package com.example.goa_project3;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String cuisine;
    private Integer image;
    private ArrayList<Category> categories;
    private Double rating;

    public Restaurant(String name, String cuisine, Integer image, ArrayList<Category> categories, Double rating ){
        this.name = name;
        this.cuisine = cuisine;
        this.image = image;
        this.categories = categories;
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

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public Double getRating() {
        return rating;
    }
}
