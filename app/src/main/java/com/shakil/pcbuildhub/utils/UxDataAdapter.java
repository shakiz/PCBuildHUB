package com.shakil.pcbuildhub.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.shakil.pcbuildhub.R;

public class UxDataAdapter {
    private ArrayAdapter<String> spinnerAdapter;
    private Context context;

    public UxDataAdapter(Context context) {
        this.context = context;
    }

    public void setSpinnerAdapter(Spinner spinner, String[] dataList){
        spinnerAdapter = new ArrayAdapter<String>(context,R.layout.spinner_drop, dataList);
        spinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
    }
}
