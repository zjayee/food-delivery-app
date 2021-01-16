package com.example.goa_project3;

import android.content.Context;
import android.media.Image;
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
 * Use the {@link disheslist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartRestaurantFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String RESTAURANT = "retaurant";
    private static final String DISHES = "dishes";


    public CartRestaurantFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param restaurant title of list
     * @param dishes contents of list
     * @return A new instance of fragment disheslist.
     */

    public static CartRestaurantFragment newInstance(Restaurant restaurant, ArrayList<Dish> dishes) {
        CartRestaurantFragment fragment = new CartRestaurantFragment();
        Bundle args = new Bundle();
        args.putSerializable(RESTAURANT, restaurant);
        args.putSerializable(DISHES, dishes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            restaurant = (Restaurant) getArguments().getSerializable(RESTAURANT);
            dishes = (ArrayList<Dish>) getArguments().getSerializable(DISHES);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_cart_restaurant, container, false);
        setupRestaurant();
        setupRecyclerView();
        return rootView;
    }

    private Restaurant restaurant;
    private ArrayList<Dish> dishes;
    private View rootView;
    private RecyclerView recyclerView;

    private void setupRestaurant(){

        TextView restaurantNameText = rootView.findViewById(R.id.restaurantname);
        RatingBar ratingBar = rootView.findViewById(R.id.ratingBar);

        restaurantNameText.setText(restaurant.getName());
        ratingBar.setRating(restaurant.getRating());


    }

    private void  setupRecyclerView(){
        recyclerView = rootView.findViewById(R.id.dishrecyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        //create linear layout manager for recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        //set adaptor
        DishAdapter dishAdapter = new DishAdapter(getContext(), dishes);
        recyclerView.setAdapter(dishAdapter);

    }



    private class DishAdapter extends RecyclerView.Adapter<DishViewHolder>{
        Context context;
        ArrayList<Dish> dishes;

        DishAdapter(Context context, ArrayList<Dish> dishes){
            this.context = context;
            this.dishes = dishes;
        }
        @NonNull
        @Override
        public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.dishcardborderless, parent, false);
            DishViewHolder viewHolder = new DishViewHolder(itemView);
            return viewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
            Dish dish = dishes.get(position);

            holder.dishimage.setImageResource(dish.getImage());
            holder.dishname.setText(dish.getName());
            holder.dishdescription.setText(dish.getDescription());
            holder.dishprice.setText("$"+dish.getPrice());


        }

        @Override
        public int getItemCount() {
            return dishes.size();
        }
    }

    private class DishViewHolder extends RecyclerView.ViewHolder{

        public View itemView;
        public ImageView dishimage;
        public TextView dishname;
        public TextView dishdescription;
        public TextView dishprice;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.dishimage = itemView.findViewById(R.id.dishimage);
            this.dishname = itemView.findViewById(R.id.dishname);
            this.dishdescription = itemView.findViewById(R.id.dishdescription);
            this.dishprice = itemView.findViewById(R.id.price);

        }
    }



}