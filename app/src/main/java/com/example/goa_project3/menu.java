package com.example.goa_project3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menu extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CURRENTPAGE = "currentpage";


    private String currentPage;


    public menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param currentPage Parameter 1.
     * @return A new instance of fragment menu.
     */

    public static menu newInstance(String currentPage) {
        menu fragment = new menu();
        Bundle args = new Bundle();
        args.putString(CURRENTPAGE, currentPage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentPage = getArguments().getString(CURRENTPAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        setupbuttons();
        return  rootView;
    }

    private View rootView;
    private Button home;
    private Button cart;
    private Button order;
    private Button favourites;
    private Button rewards;
    private ImageButton nightmode;
    boolean isNight = false;



    @SuppressLint("ResourceAsColor")
    private void setupbuttons(){
        home = rootView.findViewById(R.id.homebutton);
        cart = rootView.findViewById(R.id.cartbutton);
        order = rootView.findViewById(R.id.trackorderbutton);
        favourites = rootView.findViewById(R.id.favouritesbutton);
        rewards = rootView.findViewById(R.id.rewardsbutton);
        nightmode = rootView.findViewById(R.id.nightmodebutton);


        //TODO: set on click listeners to go to pages
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nightmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNight == false){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    isNight = true;
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    isNight = false;
                }
            }
        });

    }
}