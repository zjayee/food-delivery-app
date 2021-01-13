package com.example.goa_project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class RestaurantActivity extends AppCompatActivity {

    Restaurant restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        restaurant = (Restaurant)extras.getSerializable("restaurant");


        setupRestaurantCover();

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
}