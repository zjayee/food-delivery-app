package com.example.goa_project3;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<Dish> dishes;

    public Category(@NonNull String name, @NonNull ArrayList<Dish> dishes){
        this.name = name;
        this.dishes = dishes;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Dish> getDishes(){
        return dishes;
    }

}
