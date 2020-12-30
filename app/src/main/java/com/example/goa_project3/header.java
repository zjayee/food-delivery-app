package com.example.goa_project3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link header#newInstance} factory method to
 * create an instance of this fragment.
 */
public class header extends Fragment {

    public header() {
        // Required empty public constructor
    }


    public static header newInstance() {
        header fragment = new header();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_header, container, false);
        setupProperties();
        return rootView;
    }

    View rootView;
    String location = "Vancouver";

    private void setupProperties(){
        TextView locationtext = rootView.findViewById(R.id.locationtextview);
        locationtext.setText(location);
    }

}