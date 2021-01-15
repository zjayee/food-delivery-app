package com.example.goa_project3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart {

    //properties
    private static HashMap<Restaurant, ArrayList<Dish>> cartContents;

    // Singleton
    public static Cart getInstance() {
        if (sharedInstance == null) {
            sharedInstance = new Cart();
        }
        return sharedInstance;
    }

    private static Cart sharedInstance = null;

    private Cart() {
    }  // Don't allow instantiation outside of this class

    public static Cart getSharedInstance() {
        return sharedInstance;
    }

    public static HashMap<Restaurant, ArrayList<Dish>> getCartContents() {
        return cartContents;
    }

    public static void addCartItem(Restaurant restaurant, Dish dish, Integer quantity) {
        for (int i = 0; i < quantity; i++) {
            cartContents.get(restaurant).add(dish);
        }

    }

    public static Integer getTotalPrice(){
        Integer totalPrice = 0;
        Iterator it = cartContents.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            ArrayList<Dish> dishes = (ArrayList<Dish>)pair.getValue();
            for(int i = 0; i<dishes.size(); i++){
                totalPrice +=dishes.get(i).getPrice();
            }

        }
        return totalPrice;
    }

    public static Integer getItemNum(){
        Integer numitems = 0;
        Iterator it = cartContents.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            ArrayList<Dish> dishes = (ArrayList<Dish>)pair.getValue();
            for(int i = 0; i<dishes.size(); i++){
               numitems++;
            }

        }
        return numitems;
    }
}
