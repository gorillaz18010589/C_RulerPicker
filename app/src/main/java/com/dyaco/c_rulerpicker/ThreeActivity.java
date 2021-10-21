package com.dyaco.c_rulerpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ThreeActivity extends AppCompatActivity {
    private RulerValuePicker rulerViewLeft;
    private TextView tvTotalTime,tvLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        rulerViewLeft = findViewById(R.id.rulerViewLeft);
        tvTotalTime = findViewById(R.id.tvTotalTime);

//        setRulerVLevelView();
        rulerViewLeft.setValuePickerListener(new RulerValuePickerListener() {
            @Override
            public void onValueChange(int selectedValue) {
                Log.v("hank","setValuePickerListener() onValueChange -> selectedValue:" + selectedValue);
            }

            @Override
            public void onIntermediateValueChange(int selectedValue) {
                tvTotalTime.setText(String.valueOf(selectedValue));
                Log.v("hank","setValuePickerListener() onIntermediateValueChange -> selectedValue:" + selectedValue);

            }
        });
    }

    private void setRulerVLevelView() {
        rulerViewLeft.setTextSize(0);
        rulerViewLeft.setMinMaxValue(7,20);
        rulerViewLeft.setIndicatorIntervalDistance(50);
        rulerViewLeft.setIndicatorHeight(0.16f,0.16f);
        rulerViewLeft.selectValue(10);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }
}