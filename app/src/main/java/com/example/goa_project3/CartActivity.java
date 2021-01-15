package com.example.goa_project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartActivity extends AppCompatActivity {

    Cart cart;
    HashMap<Restaurant, ArrayList<Dish>> cartContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cart = Cart.getInstance();
        cartContents = cart.getCartContents();

        setupCartItems();

    }

    private void setupCartItems(){
//        menu = restaurant.getMenu();
//        Iterator it = menu.entrySet().iterator();
//        while (it.hasNext()){
//            String heading;
//            ArrayList<Dish> dishes;
//            Map.Entry pair = (Map.Entry)it.next();
//            heading = (String)pair.getKey();
//            dishes = (ArrayList<Dish>)pair.getValue();
//
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            //create disheslist fragment
//            Fragment disheslist = disheslistr.newInstance(heading, dishes);
//
//            //add to linear layout
//            fragmentTransaction.add(R.id.disheslistscontainer,disheslist);
//
//            //end fragment transaction
//            fragmentTransaction.commit();
//
//        }
    }

}