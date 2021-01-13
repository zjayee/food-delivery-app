package com.example.goa_project3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link restaurantcover#newInstance} factory method to
 * create an instance of this fragment.
 */
public class restaurantcover extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String RESTAURANT = "restaurant";

    // TODO: Rename and change types of parameters
    private Restaurant restaurant;

    public restaurantcover() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param restaurant Parameter 1.
     * @return A new instance of fragment restaurantcover.
     */
    // TODO: Rename and change types and number of parameters
    public static restaurantcover newInstance(Restaurant restaurant) {
        restaurantcover fragment = new restaurantcover();
        Bundle args = new Bundle();
        args.putSerializable(RESTAURANT, restaurant);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            restaurant = (Restaurant)getArguments().getSerializable(RESTAURANT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_restaurantcover, container, false);
        setUp();
        return rootView;
    }

    private View rootView;
    private TextView restaurantName;
    private TextView locationName;
    private TextView timetext;
    private ImageView coverImage;
    private ImageButton favouritebutton;
    private RatingBar ratingBar;

    private void setUp(){
        restaurantName = rootView.findViewById(R.id.restaurantname);
        locationName = rootView.findViewById(R.id.locationtextview);
        timetext = rootView.findViewById(R.id.timenumbertextview);
        ratingBar = rootView.findViewById(R.id.ratingBar);
        coverImage = rootView.findViewById(R.id.restaurantimage);
        favouritebutton = rootView.findViewById(R.id.favouritesbutton);

        restaurantName.setText(restaurant.getName());
        locationName.setText("Vancouver");

        Integer min = (int)Math.random()*20+4;
        Integer max = min+(int)Math.random()*5+5;

        timetext.setText(min.toString()+"-"+max);
        ratingBar.setRating(restaurant.getRating());
        coverImage.setImageResource(restaurant.getImage());



    }
}