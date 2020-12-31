package com.example.goa_project3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private void setProperties(){
        
    }

    private void setButtons(){

    }


}