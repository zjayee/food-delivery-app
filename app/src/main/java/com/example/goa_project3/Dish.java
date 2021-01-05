package com.example.goa_project3;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class Dish {
    private String name;
    private String description;
    private Integer image;
    private Integer price;
    private float rating;

    public Dish(@NonNull String name, @NonNull String description, @NonNull Integer image, @NonNull Integer price){
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.rating = (float)Math.random()*3+2;
    }


    public HashMap<String, String> getDish(){
        HashMap<String, String> dish = new HashMap<>();
        dish.put("name", name);
        dish.put("description", description);
        dish.put("image", Integer.toString(image));
        dish.put("price",Integer.toString(price));
        dish.put("rating", Double.toString(rating));

        return  dish;

    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Integer getImage(){
        return image;
    }

    public Integer getPrice(){
        return price;
    }

    public float getRating(){
        return rating;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
