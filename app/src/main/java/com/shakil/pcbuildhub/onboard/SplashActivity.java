package com.shakil.pcbuildhub.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.shakil.pcbuildhub.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView nextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,WelcomeHomeActivity.class));
            }
        });
    }

    private void init() {
        nextPage = findViewById(R.id.nextPage);
    }
}
