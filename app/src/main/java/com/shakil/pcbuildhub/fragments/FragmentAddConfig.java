package com.shakil.pcbuildhub.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shakil.pcbuildhub.R;

public class FragmentAddConfig extends Fragment implements View.OnClickListener {

    private static final FragmentAddConfig FRAGMENT_ADD_CONFIG = null;
    private Button chooseMotherBoard;
    private Context context;

    public static synchronized FragmentAddConfig getInstance(){
        if (FRAGMENT_ADD_CONFIG == null) return new FragmentAddConfig();
        else return FRAGMENT_ADD_CONFIG;
    }

    public FragmentAddConfig() {
        
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_config, container, false);
        init(view);
        bindUiWithComponents();
        return view;
    }

    private void init(View view) {
        chooseMotherBoard = view.findViewById(R.id.motherboardButton);
    }

    private void bindUiWithComponents() {
        chooseMotherBoard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.motherboardButton:
                showDialog();
        }
    }

    private void showDialog() {
        AlertDialog.Builder itemDialog = new AlertDialog.Builder(context);
        itemDialog.setView(R.layout.generic_list_layout);
        itemDialog.show();
    }
}
