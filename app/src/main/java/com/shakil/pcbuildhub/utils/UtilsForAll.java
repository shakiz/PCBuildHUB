package com.shakil.pcbuildhub.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.shakil.pcbuildhub.R;

public class UtilsForAll {

    private Context context;
    private View view;

    public UtilsForAll(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public UtilsForAll(Context context) {
        this.context = context;
    }

    public UtilsForAll(View view) {
        this.view = view;
    }

    public static void exitApp(Context context){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(exitIntent);
    }

    public void setCustomDesignTextView(int resId){
        TextView textView = view.findViewById(resId);
        textView.setTextColor(view.getResources().getColor(R.color.md_blue_grey_800));
        textView.setSingleLine();
    }

    public int toIntValue(String value){
        try{
            Log.v("shakil",""+Integer.parseInt(value));
            return Integer.parseInt(value);
        }
        catch (Exception e){
            Log.v("shakil",e.getMessage());
            return 0;
        }
    }
}
