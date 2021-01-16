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
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link disheslistr#newInstance} factory method to
 * create an instance of this fragment.
 */
public class disheslistr extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String HEADING = "heading";
    private static final String DISHES = "dishes";
    private static final String RESTAURANT = "restaurant";


    public disheslistr() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param heading title of list
     * @param dishes contents of list
     * @return A new instance of fragment disheslist.
     */

    public static disheslistr newInstance(String heading, ArrayList<Dish> dishes, Restaurant restaurant) {
        disheslistr fragment = new disheslistr();
        Bundle args = new Bundle();
        args.putString(HEADING, heading);
        args.putSerializable(DISHES, dishes);
        args.putSerializable(RESTAURANT,restaurant);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            heading = getArguments().getString(HEADING);
            dishes = (ArrayList<Dish>) getArguments().getSerializable(DISHES);
            restaurant = (Restaurant) getArguments().getSerializable(RESTAURANT);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_disheslistr, container, false);
        setupHeading();
        setupRecyclerView();
        cart = Cart.getInstance();
        cartContents = Cart.getCartContents();
        return rootView;

    }

    private String heading;
    private ArrayList<Dish> dishes;
    private Restaurant restaurant;
    private View rootView;
    private RecyclerView recyclerView;
    Cart cart;
    HashMap<Restaurant,ArrayList<Dish>> cartContents;

    private void setupHeading(){
        TextView headingtextview = rootView.findViewById(R.id.labeltextview);
        headingtextview.setText(heading);

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

    private void userTappedOnPosition(int position, View itemview){

        //if pickernumberstepper tapped add to cart, update item number
        Dish dish = dishes.get(position);
        pickernumberstepper pickernumberstepper = itemview.findViewById(R.id.pickernumberstepper);
        Integer quantity = pickernumberstepper.getCurrentValue();
        Integer oldQuantity = 0;

        //update dish quantity in cart
        HashMap<Restaurant, ArrayList<Dish>> cartContents = Cart.getCartContents();
       ArrayList<Dish> cartDishes = cartContents.get(restaurant);
       if(cartDishes!=null){
           for(int i = 0; i<cartDishes.size(); i++){
               if (cartDishes.get(i).getName().equals(dish.getName())){
                   oldQuantity++;
               }
           }
       }else{
           oldQuantity = 0;
           ArrayList<Dish> dishArrayList= new ArrayList<>();
           cartContents.put(restaurant,dishArrayList);
           cartDishes = cartContents.get(restaurant);
       }


           while(oldQuantity<quantity){
               cartDishes.add(dish);
               oldQuantity++;
           }


           while(quantity>oldQuantity) {
               for (int i = 0; i < cartDishes.size(); i++) {
                   if (cartDishes.get(i).getName().equals(dish.getName())) {
                       cartDishes.remove(i);
                       quantity--;
                       break;
                   }
               }
           }



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
            View itemView = inflater.inflate(R.layout.dish_cardr, parent, false);
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


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            holder.pickernumberstepper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userTappedOnPosition(position, holder.itemView);
                }
            });

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
        public pickernumberstepper pickernumberstepper;


        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.dishimage = itemView.findViewById(R.id.dishimage);
            this.dishname = itemView.findViewById(R.id.dishname);
            this.dishdescription = itemView.findViewById(R.id.dishdescription);
            this.dishprice = itemView.findViewById(R.id.price);
            this.pickernumberstepper = itemView.findViewById(R.id.pickernumberstepper);

        }
    }



}