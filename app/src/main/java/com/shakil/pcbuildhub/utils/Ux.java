package com.shakil.pcbuildhub.utils;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.shakil.pcbuildhub.R;

public class Ux {
    private ArrayAdapter<String> spinnerAdapter;
    private Context context;

    public Ux(Context context) {
        this.context = context;
    }

    public void setSpinnerAdapter(Spinner spinner, String[] dataList){
        spinnerAdapter = new ArrayAdapter<String>(context,R.layout.spinner_drop, dataList);
        spinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
    }

    public void clearUI(int[] resIds,View view){
        for (int resId : resIds){
            TextView textView = view.findViewById(resId);
            textView.setText("");
            textView.setVisibility(View.GONE);
        }
    }
}
