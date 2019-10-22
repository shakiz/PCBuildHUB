package com.shakil.pcbuildhub.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shakil.pcbuildhub.R;

public class FragmentAddConfig extends Fragment {

    private static final FragmentAddConfig FRAGMENT_ADD_CONFIG = null;

    public static synchronized FragmentAddConfig getInstance(){
        if (FRAGMENT_ADD_CONFIG == null) return new FragmentAddConfig();
        else return FRAGMENT_ADD_CONFIG;
    }

    public FragmentAddConfig() {
        
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
    }

    private void bindUiWithComponents() {
    }

}
