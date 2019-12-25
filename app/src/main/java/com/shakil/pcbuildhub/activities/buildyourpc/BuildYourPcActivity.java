package com.shakil.pcbuildhub.activities.buildyourpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.activities.onboard.HomeActivity;

public class BuildYourPcActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_your_pc);
        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuildYourPcActivity.this, HomeActivity.class));
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
    }
}
