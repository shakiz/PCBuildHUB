package com.shakil.pcbuildhub.activities.buildyourpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.databinding.ActivityBuildYourPcBinding;

public class BuildYourPcActivity extends AppCompatActivity {


    private ActivityBuildYourPcBinding buildYourPcBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildYourPcBinding = DataBindingUtil.setContentView(this , R.layout.activity_build_your_pc);
        setSupportActionBar(buildYourPcBinding.toolBar);

        init();
        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
        buildYourPcBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuildYourPcActivity.this, BuildYourPcListActivity.class));
            }
        });
    }

    private void init() {
        
    }
}
