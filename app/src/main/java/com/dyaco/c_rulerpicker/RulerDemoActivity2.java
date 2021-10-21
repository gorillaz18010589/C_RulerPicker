package com.dyaco.c_rulerpicker;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class RulerDemoActivity2 extends AppCompatActivity {
    private CircleImageView profile_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler_demo2);

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//        }

        final TextInputEditText nameEt = findViewById(R.id.profile_name_et);
        profile_image = findViewById(R.id.profile_image);

        profile_image.setOnClickListener(v ->{
            startActivity(new Intent(RulerDemoActivity2.this, ThreeActivity.class));
        });

        nameEt.setText("Audrey Jessica");

        //Set the height picker
        final TextView heightPickerValueTv = findViewById(R.id.height_value_tv);
        final RulerValuePicker heightPicker = findViewById(R.id.height_ruler_picker);
        heightPicker.selectValue(156);
        heightPicker.setValuePickerListener(new RulerValuePickerListener() {
            @Override
            public void onValueChange(final int selectedValue) {
                heightPickerValueTv.setText(selectedValue + " cms");
            }

            @Override
            public void onIntermediateValueChange(final int selectedValue) {
                heightPickerValueTv.setText(selectedValue + " cms");
            }
        });

        //Set the weight picker
        final TextView weightPickerValueTv = findViewById(R.id.weight_value_tv);
        final RulerValuePicker weightPicker = findViewById(R.id.weight_ruler_picker);
        weightPicker.setTextSize(22);


//        weightPicker.selectValue(55);
        weightPicker.setIndicatorIntervalDistance(25);
        weightPicker.setValuePickerListener(new RulerValuePickerListener() {
            @Override
            public void onValueChange(final int selectedValue) {
                weightPickerValueTv.setText(selectedValue + " kgs");

            }

            @Override
            public void onIntermediateValueChange(final int selectedValue) {
                weightPickerValueTv.setText(selectedValue + " kgs");

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }


}