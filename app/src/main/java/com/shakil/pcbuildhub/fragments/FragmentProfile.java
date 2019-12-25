package com.shakil.pcbuildhub.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.shakil.pcbuildhub.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfile extends Fragment {

    private static final FragmentProfile FRAGMENT_PROFILE = null;

    public static synchronized FragmentProfile getInstance(){
        if (FRAGMENT_PROFILE == null) return new FragmentProfile();
        else return FRAGMENT_PROFILE;
    }

    public FragmentProfile() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        init(view);
        bindUIWithComponents();
        return view;
    }

    private void bindUIWithComponents() {
    }

    private void init(View view) {
    }

}
