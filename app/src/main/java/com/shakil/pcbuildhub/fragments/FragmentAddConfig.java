package com.shakil.pcbuildhub.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shakil.pcbuildhub.R;

public class FragmentAddConfig extends Fragment {

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
