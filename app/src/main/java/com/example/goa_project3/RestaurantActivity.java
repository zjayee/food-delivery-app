package com.example.goa_project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RestaurantActivity extends AppCompatActivity {

    Restaurant restaurant;
    ImageButton backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        restaurant = (Restaurant)extras.getSerializable("restaurant");

        setupBackButton();
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
}