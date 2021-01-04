package com.example.goa_project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        createsamplerestaurantfortesting();
        setuprecommendedffragment();




    }


    ArrayList<Restaurant> recommendedrestaurants = new ArrayList<>();

    void createsamplerestaurantfortesting(){
        Restaurant restaurant = new Restaurant("a","b",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant);
        Restaurant restaurant1 = new Restaurant("c","d",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant1);
        Restaurant restaurant2 = new Restaurant("e","b",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant2);
    }

    void setuprecommendedffragment(){
        //Get linear layout xml object
        LinearLayout linearLayout = findViewById(R.id.linearlayout);

        //fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //create restaurantlist fragment
        Fragment restaurantlist = com.example.goa_project3.restaurantlist.newInstance("Recommended", recommendedrestaurants);

        //add to linear layout
        fragmentTransaction.add(linearLayout.getId(),restaurantlist,null);

        //end fragment transaction
        fragmentTransaction.commit();
    }
}

