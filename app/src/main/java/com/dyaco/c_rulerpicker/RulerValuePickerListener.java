package com.dyaco.c_rulerpicker;

public interface RulerValuePickerListener {

    void onValueChange(int selectedValue);

    void onIntermediateValueChange(int selectedValue);
}