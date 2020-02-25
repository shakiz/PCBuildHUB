package com.shakil.pcbuildhub.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.adapter.DashboardPostAdapter;
import com.shakil.pcbuildhub.model.post.PostModel;
import com.shakil.pcbuildhub.utils.DumpDummyData;
import java.util.ArrayList;

public class FragmentPostDashboard extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<PostModel> postList;
    private DashboardPostAdapter postAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;
    private DumpDummyData dumpDummyData;

    private static final FragmentPostDashboard FRAGMENT_POST_DASHBOARD = null;

    public static synchronized FragmentPostDashboard getInstance(){
        if (FRAGMENT_POST_DASHBOARD == null) return new FragmentPostDashboard();
        else return FRAGMENT_POST_DASHBOARD;
    }

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
        return inflater.inflate(R.layout.fragment_post_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.postRecyclerView);
        postList = new ArrayList<>();
        dumpDummyData = new DumpDummyData(getContext());
        binUIWithComponents();
    }

    private void binUIWithComponents(){

        dumpDummyData.newsFeed(new DumpDummyData.onNewFeedComplete() {
            @Override
            public void onComplete() {
                postList = dumpDummyData.getPostList();
                setAdapter();
            }
        });
    }


    private void setAdapter() {
        postAdapter = new DashboardPostAdapter(postList,context);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();
    }

}
