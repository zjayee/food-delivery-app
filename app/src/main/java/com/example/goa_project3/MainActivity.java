package com.example.goa_project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        createsamplerestaurantfortesting();
        createsampledishesfortesting();
        setuprecommendedffragment();
        setuppromotions();
        setupmenu();

    }


    ArrayList<Restaurant> recommendedrestaurants = new ArrayList<>();
    ArrayList<Dish> promotiondishes = new ArrayList<>();
    LinearLayout linearLayout;
    ImageButton menubutton;
    View headerfragment;
    FrameLayout outsidebox;


    void createsamplerestaurantfortesting(){
        Restaurant restaurant = new Restaurant("a","b",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant);
        Restaurant restaurant1 = new Restaurant("c","d",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant1);
        Restaurant restaurant2 = new Restaurant("e","b",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant2);
    }

    void createsampledishesfortesting(){
        Dish dish = new Dish("a","bc", R.drawable.steak, 30);
        Dish dish1 = new Dish("c","bc", R.drawable.steak, 30);
        Dish dish2 = new Dish("d","bc", R.drawable.steak, 30);
        promotiondishes.add(dish);
        promotiondishes.add(dish1);
        promotiondishes.add(dish2);
    }

    void setuprecommendedffragment(){

        //fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //create restaurantlist fragment
        Fragment restaurantlist = com.example.goa_project3.restaurantlist.newInstance("Recommended", recommendedrestaurants);

        //add to linear layout
        fragmentTransaction.replace(R.id.recommendedrestaurants,restaurantlist,null);

        //end fragment transaction
        fragmentTransaction.commit();
    }

    void setuppromotions(){
        //fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //create disheslist fragment
        Fragment disheslist = com.example.goa_project3.disheslist.newInstance("Promotions",promotiondishes);

        //add to linear layout
        fragmentTransaction.replace(R.id.promotions, disheslist,null);

        //end fragment transaction
        fragmentTransaction.commit();
    }

    void setupmenu(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

       Fragment menu = com.example.goa_project3.menu.newInstance("home");

       fragmentTransaction.replace(R.id.menu, menu, null);

        //end fragment transaction
        fragmentTransaction.commit();

        View menuview = findViewById(R.id.menu);
        headerfragment = findViewById(R.id.headerfragment);
        menubutton = headerfragment.findViewById(R.id.menubutton);


        menuview.setVisibility(View.INVISIBLE);

        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(menuview.getVisibility()==View.INVISIBLE) {
                    menuview.setVisibility(View.VISIBLE);
                }

                outsidebox = menuview.findViewById(R.id.outsidebox);
                outsidebox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(menuview.getVisibility()==View.VISIBLE){
                            menuview.setVisibility(View.INVISIBLE);
                        }
                    }
                });

            }
        });



    }


}

