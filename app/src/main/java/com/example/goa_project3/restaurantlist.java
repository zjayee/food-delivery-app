package com.example.goa_project3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link restaurantlist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class restaurantlist extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String HEADING = "heading";
    private static final String RESTAURANTS = "restaurants";


    public restaurantlist() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param heading title of list
     * @param restaurants contents of list
     * @return A new instance of fragment restaurantlist.
     */
    // TODO: Rename and change types and number of parameters
    public static restaurantlist newInstance(String heading, ArrayList<Restaurant> restaurants) {
        restaurantlist fragment = new restaurantlist();
        Bundle args = new Bundle();
        args.putString(HEADING, heading);
        args.putSerializable(RESTAURANTS, restaurants);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String heading = getArguments().getString(HEADING);
            ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) getArguments().getSerializable(RESTAURANTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurantlist, container, false);
    }
}