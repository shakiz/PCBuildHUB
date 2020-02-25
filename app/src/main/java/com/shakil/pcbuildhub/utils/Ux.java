package com.shakil.pcbuildhub.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.shakil.pcbuildhub.R;

public class Ux {
    private ArrayAdapter<String> spinnerAdapter;
    private Context context;
    public Dialog loadingDialog;

    public Ux(Context context) {
        this.context = context;
        loadingDialog = new Dialog(context);
    }

    public void getLoadingView(){
        loadingDialog.setContentView(R.layout.loading_layout);
        loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        loadingDialog.setCanceledOnTouchOutside(false);
        loadingDialog.show();
    }

    public void removeLoadingView(){
        if (loadingDialog.isShowing()) loadingDialog.cancel();
    }


    public void setSpinnerAdapter(Spinner spinner, String[] dataList){
        spinnerAdapter = new ArrayAdapter<String>(context,R.layout.spinner_drop, dataList);
        spinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
    }

    public void clearDetailsUI(int[] resIds,View view){
        for (int resId : resIds){
            TextView textView = view.findViewById(resId);
            textView.setText("");
            textView.setVisibility(View.GONE);
        }
    }
}
