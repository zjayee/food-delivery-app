package com.example.goa_project3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

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
            heading = getArguments().getString(HEADING);
            restaurants = (ArrayList<Restaurant>) getArguments().getSerializable(RESTAURANTS);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_restaurantlist, container, false);
        setupHeading();
        setupRecyclerView();
        return rootView;
    }

    private String heading;
    private ArrayList<Restaurant> restaurants;
    private View rootView;
    private RecyclerView recyclerView;

    private void setupHeading(){
        TextView headingtextview = rootView.findViewById(R.id.labeltextview);
        headingtextview.setText(heading);

    }

    private void  setupRecyclerView(){
        recyclerView = rootView.findViewById(R.id.restaurantrecyclerview);
        //adjusts height
        ViewGroup.LayoutParams params = recyclerView.getLayoutParams();
        switch (heading)
        {
            case "Recommended":
                params.height = 203;
                break;
            case "Recents":
                params.height = 167;
                break;
        }

        //create linear layout manager for recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        //set adaptor
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(getContext(), restaurants);
        recyclerView.setAdapter(restaurantAdapter);

    }

    private void userTappedOnPosition(int position){
        //TODO: Navigate to restaurant details screen

    }

    private class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder>{
        Context context;
        ArrayList<Restaurant> restaurants;

        RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants){
            this.context = context;
            this.restaurants = restaurants;
        }
        @NonNull
        @Override
        public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.restaurant_card, parent, false);
            RestaurantViewHolder viewHolder = new RestaurantViewHolder(itemView);
            return viewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
            Restaurant restaurant = restaurants.get(position);
            holder.restaurantName.setText(restaurant.getName());
            holder.restaurantCategory.setText(restaurant.getCuisine());
            holder.ratingBar.setRating(restaurant.getRating());
            holder.restaurantImage.setImageResource(restaurant.getImage());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   userTappedOnPosition(position);
                }
            });

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private class RestaurantViewHolder extends RecyclerView.ViewHolder{

        public View itemView;
        public ImageView restaurantImage;
        public TextView restaurantName;
        public TextView restaurantCategory;
        public RatingBar ratingBar;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            restaurantImage = itemView.findViewById(R.id.restaurantimage);
            restaurantName = itemView.findViewById(R.id.restaurantname);
            restaurantCategory = itemView.findViewById(R.id.ratingBar);

        }
    }



}