package com.example.goa_project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

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
        setupHeadings();

    }

    private void setupCartItems(){

        Iterator it = cartContents.entrySet().iterator();
        while(it.hasNext()){
            Restaurant restaurant;
            ArrayList<Dish> dishes;
            Map.Entry pair = (Map.Entry)it.next();
            restaurant = (Restaurant)pair.getKey();
            dishes = (ArrayList<Dish>) pair.getValue();

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment cartRestaurantFragment = com.example.goa_project3.CartRestaurantFragment.newInstance(restaurant,dishes);

            fragmentTransaction.add(R.id.dishfragmentcontainer,cartRestaurantFragment);

            fragmentTransaction.commit();

        }
    }


    private void setupHeadings(){
        Integer amount = Cart.getItemNum();
        Integer totalPrice = Cart.getTotalPrice();

        TextView carttext = findViewById(R.id.cartText);
        carttext.setText("My Cart ("+amount+")");

        TextView numItemsText = findViewById(R.id.totalitemstext);
        numItemsText.setText(amount+" Items");

        TextView totalPriceText = findViewById(R.id.totalnumbertext);
        totalPriceText.setText("$"+totalPrice);

    }

}