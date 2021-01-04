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
        setuprecommendedffragment();
       // setupcategories();



    }


    ArrayList<Restaurant> recommendedrestaurants = new ArrayList<>();
    LinearLayout linearLayout;

    void createsamplerestaurantfortesting(){
        Restaurant restaurant = new Restaurant("a","b",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant);
        Restaurant restaurant1 = new Restaurant("c","d",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant1);
        Restaurant restaurant2 = new Restaurant("e","b",R.drawable.steak, null, (float) 3.4);
        recommendedrestaurants.add(restaurant2);
    }

    void setuprecommendedffragment(){
        linearLayout = findViewById(R.id.linearlayout);
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

//    void setupcategories(){
//        linearLayout = findViewById(R.id.linearlayout);
//        TextView categoriestext = new TextView(this);
//        categoriestext.setText("Categories");
//        categoriestext.setId(View.generateViewId());
//        categoriestext.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        Typeface font = ResourcesCompat.getFont(this, R.font.playfair_display_bold);
//        categoriestext.setTypeface(font);
//        categoriestext.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
//        categoriestext.setTextColor(getResources().getColor(R.color.text1,null));
//        linearLayout.addView(categoriestext);
//
//    }
}

