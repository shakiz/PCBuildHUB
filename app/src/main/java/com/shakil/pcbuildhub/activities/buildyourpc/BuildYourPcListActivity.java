package com.shakil.pcbuildhub.activities.buildyourpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.adapter.BuildYourPcAdapter;
import com.shakil.pcbuildhub.databinding.ActivityBuildYourPcListBinding;
import com.shakil.pcbuildhub.model.buildyourpc.BuildYourPc;

import java.util.ArrayList;

public class BuildYourPcListActivity extends AppCompatActivity {
    private ActivityBuildYourPcListBinding buildYourPcListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildYourPcListBinding = DataBindingUtil.setContentView(this , R.layout.activity_build_your_pc_list);

        init();
        bindUIWithComponents();
    }

    private void init() {

    }

    private void bindUIWithComponents() {
        setAdapter();
    }

    private void setAdapter() {
        BuildYourPcAdapter buildYourPcAdapter = new BuildYourPcAdapter(setData(), this, new BuildYourPcAdapter.onItemClickListener() {
            @Override
            public void respond(BuildYourPc buildYourPc) {
                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        buildYourPcListBinding.buildOwnConfigRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        buildYourPcListBinding.buildOwnConfigRecyclerView.setAdapter(buildYourPcAdapter);
        buildYourPcAdapter.notifyDataSetChanged();
    }

    private ArrayList<BuildYourPc> setData() {
        ArrayList<BuildYourPc> buildYourPcList = new ArrayList<>();
        buildYourPcList.add(new BuildYourPc("Test","2015-12-12","Test",1000));
        return buildYourPcList;
    }
}
