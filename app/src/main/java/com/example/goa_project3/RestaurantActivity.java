package com.example.goa_project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RestaurantActivity extends AppCompatActivity {

    Restaurant restaurant;
    ImageButton backbutton;
    HashMap menu;
    CardView toCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        restaurant = (Restaurant)extras.getSerializable("restaurant");

        setupBackButton();
        setupRestaurantCover();
        setupDishesFragment();
        setupItemNumber();
        setupToCheckout();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setupItemNumber();
    }

    void setupRestaurantCover(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //create restaurantcover fragment
        Fragment restaurantcover = com.example.goa_project3.restaurantcover.newInstance(restaurant);

        //add to layout
        fragmentTransaction.replace(R.id.restaurantcover, restaurantcover,null);

        //end fragment transaction
        fragmentTransaction.commit();

    }

    void setupBackButton(){
        backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupDishesFragment(){

        menu = restaurant.getMenu();
        Iterator it = menu.entrySet().iterator();
        while (it.hasNext()){
            String heading;
            ArrayList<Dish> dishes;
            Map.Entry pair = (Map.Entry)it.next();
            heading = (String)pair.getKey();
            dishes = (ArrayList<Dish>)pair.getValue();

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //create disheslist fragment
            Fragment disheslist = disheslistr.newInstance(heading, dishes, restaurant);

            //add to linear layout
            fragmentTransaction.add(R.id.disheslistscontainer,disheslist);

            //end fragment transaction
            fragmentTransaction.commit();

        }
    }

    void setupItemNumber(){
        TextView itemNumberText = findViewById(R.id.itemsnumbertext);
        //TODO: set item numbers to correct number
        Cart cart = Cart.getInstance();
        HashMap<Restaurant, ArrayList<Dish>> cartContents = Cart.getCartContents();
        Integer itemNumber;
        if(cartContents.containsKey(restaurant)) {
            ArrayList<Dish> cartDishes = cartContents.get(restaurant);

                itemNumber = cartDishes.size();

        }else{
            itemNumber = 0;
        }
        itemNumberText.setText(itemNumber + " Items");
    }

    private void setupToCheckout(){
        toCheckout = findViewById(R.id.tocheckoutbutton);

        toCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CartActivity.class);
                startActivity(intent);

            }
        });

    }


}