package com.example.goa_project3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class pickernumberstepper extends LinearLayout implements View.OnClickListener {
    Integer minimumValue = 0;
    Integer maximumValue = 15;
    Integer currentValue = 0;

    public pickernumberstepper(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //inflate layout file
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.pickernumberstepper,this,true);

        //connect text view
        amounttextview = findViewById(R.id.amounttextview);

        //subtract button
        ImageButton subtract = findViewById(R.id.minus);
        subtract.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentValue>minimumValue){
                    currentValue--;
                }
                refreshCurrentValue();
                performClick();
            }
        });

        //add button
        ImageButton add = findViewById(R.id.plus);
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentValue<maximumValue){
                    currentValue++;
                }
                refreshCurrentValue();
                performClick();
            }
        });


    }

    private void refreshCurrentValue(){
        amounttextview.setText(currentValue.toString());
    }

    TextView amounttextview;

    @Override
    public void onClick(View v) {

    }

}
