package com.shakil.pcbuildhub.activities.buildyourpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.activities.onboard.HomeActivity;
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

        setSupportActionBar(buildYourPcListBinding.toolBar);

        buildYourPcListBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuildYourPcListActivity.this, HomeActivity.class));
            }
        });

        init();
        bindUIWithComponents();
    }

    private void init() {

    }

    private void bindUIWithComponents() {
        setAdapter();

        buildYourPcListBinding.addBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuildYourPcListActivity.this,BuildYourOwnPcActivity.class));
            }
        });
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
        buildYourPcList.add(new BuildYourPc("Sample Title 1","2015-12-12","Gaming",25000));
        buildYourPcList.add(new BuildYourPc("Sample Title 2","2019-10-16","Production",10000));
        buildYourPcList.add(new BuildYourPc("Sample Title 3","2016-10-18","Streaming",60000));
        return buildYourPcList;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BuildYourPcListActivity.this , HomeActivity.class));
    }
}
