package com.shakil.pcbuildhub.activities.buildyourpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.databinding.ActivityBuildYourOwnPcBinding;

public class BuildYourOwnPcActivity extends AppCompatActivity {

    private ActivityBuildYourOwnPcBinding activityBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBinding = DataBindingUtil.setContentView(this , R.layout.activity_build_your_own_pc);
        setSupportActionBar(activityBinding.toolBar);

        init();
        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
        activityBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuildYourOwnPcActivity.this, BuildYourPcListActivity.class));
            }
        });
    }

    private void init() {

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BuildYourOwnPcActivity.this , BuildYourPcListActivity.class));
    }
}
