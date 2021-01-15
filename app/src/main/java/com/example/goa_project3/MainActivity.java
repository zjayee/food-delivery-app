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
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        HashMap<String, ArrayList<Dish>> menu = new HashMap<>();
        ArrayList<Dish> popularItems = new ArrayList<>();
        Dish dish = new Dish("Alaska Roll","Avocado, salmon on the top, cucumber", R.drawable.alaskaroll, 6);
        Dish dish1 = new Dish("Dynamite Roll","Prawn tempura, lettuce, cucumber", R.drawable.dynamiteroll, 6);
        Dish dish2 = new Dish("California Roll","Crab meat, cucumber, avocado", R.drawable.californiaroll, 5);
        Dish dish3 = new Dish("Salmon Sashimi","Spicy salmon sashimi", R.drawable.spicysalmonsashimi, 9);
        popularItems.add(dish);
        popularItems.add(dish1);
        popularItems.add(dish2);
        popularItems.add(dish3);


        ArrayList<Dish> rolls = new ArrayList<>();
        Dish rdish = new Dish("Alaska Roll","Avocado, salmon on the top, cucumber", R.drawable.alaskaroll, 6);
        Dish rdish1 = new Dish("Dynamite Roll","Prawn tempura, lettuce, cucumber", R.drawable.dynamiteroll, 6);
        Dish rdish2 = new Dish("California Roll","Crab meat, cucumber, avocado", R.drawable.californiaroll, 5);
        rolls.add(rdish);
        rolls.add(rdish1);
        rolls.add(rdish2);
        menu.put("Rolls", rolls);
        menu.put("Popular Items", popularItems);

        Restaurant restaurant = new Restaurant("Sushi Garden","Asian",R.drawable.sushi, menu, (float) 4.8);
        recommendedrestaurants.add(restaurant);
        Restaurant restaurant1 = new Restaurant("The Keg","Western",R.drawable.steak, null, (float) 4.2);
        recommendedrestaurants.add(restaurant1);
        Restaurant restaurant2 = new Restaurant("Mcdonalds","Fast Food",R.drawable.mcdonalds, null, (float) 3.4);
        recommendedrestaurants.add(restaurant2);
    }

    void createsampledishesfortesting(){
        Dish dish = new Dish("Alaska Roll","Avocado, salmon on the top, cucumber", R.drawable.alaskaroll, 6);
        Dish dish1 = new Dish("Hamburger","Bread, Beef Patty, Cheese", R.drawable.mcdonalds, 4);
        Dish dish2 = new Dish("Salmon Sashimi","Spicy salmon sashimi", R.drawable.spicysalmonsashimi, 9);
        Dish dish3 = new Dish("Steak and Fries","Steak with a side of fried", R.drawable.steak, 32);
        promotiondishes.add(dish);
        promotiondishes.add(dish1);
        promotiondishes.add(dish2);
        promotiondishes.add(dish3);
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

