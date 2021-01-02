package com.example.goa_project3;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link categorylist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class categorylist extends Fragment {



    public categorylist() {
        // Required empty public constructor
    }

    public static categorylist newInstance(String param1, String param2) {
        categorylist fragment = new categorylist();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_categorylist, container, false);
        setProperties();
        setButtons();
        return rootView;
    }

    private View rootView;
    private View veganCard;
    private View asianCard;
    private View westernCard;
    private View mexicanCard;
    private View fastFoodCard;
    private View greekCard;

    private void setProperties(){
    //find layout views with ids
        veganCard = rootView.findViewById(R.id.vegan);
        asianCard = rootView.findViewById(R.id.asian);
        westernCard = rootView.findViewById(R.id.western);
        mexicanCard = rootView.findViewById(R.id.mexican);
        fastFoodCard = rootView.findViewById(R.id.fastfood);
        greekCard = rootView.findViewById(R.id.greek);

     //find images
        ImageView veganicon = veganCard.findViewById(R.id.categoryimage);
        ImageView asianicon = asianCard.findViewById(R.id.categoryimage);
        ImageView westernicon = westernCard.findViewById(R.id.categoryimage);
        ImageView mexicanicon = mexicanCard.findViewById(R.id.categoryimage);
        ImageView fastfoodicon = fastFoodCard.findViewById(R.id.categoryimage);
        ImageView greekicon = greekCard.findViewById(R.id.categoryimage);

    //set images
        veganicon.setImageResource(R.drawable.vegan);
        asianicon.setImageResource(R.drawable.asian);
        westernicon.setImageResource(R.drawable.western);
        mexicanicon.setImageResource(R.drawable.mexican);
        fastfoodicon.setImageResource(R.drawable.fastfood);
        greekicon.setImageResource(R.drawable.greek);

    //find text
        TextView vegantext = veganCard.findViewById(R.id.categoryname);
        TextView asiantext = asianCard.findViewById(R.id.categoryname);
        TextView westerntext = westernCard.findViewById(R.id.categoryname);
        TextView mexicantext = mexicanCard.findViewById(R.id.categoryname);
        TextView fastfoodtext = fastFoodCard.findViewById(R.id.categoryname);
        TextView greektext = greekCard.findViewById(R.id.categoryname);

    //set text
        vegantext.setText("Vegan");
        asiantext.setText("Asian");
        westerntext.setText("Western");
        mexicantext.setText("Mexican");
        fastfoodtext.setText("Fast Food");
        greektext.setText("Greek");

    //set colour of icons
        ImageViewCompat.setImageTintList(veganicon, ColorStateList.valueOf(ContextCompat.getColor(rootView.getContext(), R.color.text2)));
        ImageViewCompat.setImageTintList(asianicon, ColorStateList.valueOf(ContextCompat.getColor(rootView.getContext(), R.color.text2)));
        ImageViewCompat.setImageTintList(westernicon, ColorStateList.valueOf(ContextCompat.getColor(rootView.getContext(), R.color.text2)));
        ImageViewCompat.setImageTintList(mexicanicon, ColorStateList.valueOf(ContextCompat.getColor(rootView.getContext(), R.color.text2)));
        ImageViewCompat.setImageTintList(fastfoodicon, ColorStateList.valueOf(ContextCompat.getColor(rootView.getContext(), R.color.text2)));
        ImageViewCompat.setImageTintList(greekicon, ColorStateList.valueOf(ContextCompat.getColor(rootView.getContext(), R.color.text2)));
    }

    private void setButtons(){

    }


}