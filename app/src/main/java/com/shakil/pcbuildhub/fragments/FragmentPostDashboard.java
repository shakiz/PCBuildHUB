package com.shakil.pcbuildhub.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.adapter.DashboardPostAdapter;
import com.shakil.pcbuildhub.model.PostModel;
import java.util.ArrayList;

public class FragmentPostDashboard extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<PostModel> postModelList;
    private DashboardPostAdapter postAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;

    public FragmentPostDashboard() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_dashboard, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.postRecyclerView);
        postModelList = new ArrayList<>();
        binUIWithComponents();
    }

    private void binUIWithComponents(){
        setData();
        setAdapter();
    }

    private void setData() {
        postModelList.add(new PostModel("Great AMD Gaming/Streaming Build","Shakil","10-10-2019"));
        postModelList.add(new PostModel("Enthusiast AMD Gaming/Streaming Build","Zas","10-10-2019"));
        postModelList.add(new PostModel("Magnificent Intel Gaming/Streaming Build","David","10-10-2019"));
        postModelList.add(new PostModel("Entry Level AMD Gaming Build","Saim","10-10-2019"));
        postModelList.add(new PostModel("Modest AMD Gaming Build","Koushik","10-10-2019"));
        postModelList.add(new PostModel("Portable LAN Build","Robi","10-10-2019"));
        postModelList.add(new PostModel("Budget Home/Office Build","Shawon","10-10-2019"));
    }

    private void setAdapter() {
        postAdapter = new DashboardPostAdapter(postModelList,context);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();
    }

}
