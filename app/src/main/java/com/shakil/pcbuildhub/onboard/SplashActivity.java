package com.shakil.pcbuildhub.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.shakil.pcbuildhub.R;

public class SplashActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private ImageView nextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        linearLayout.startAnimation(a);
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
        linearLayout = findViewById(R.id.mainLayout);
        nextPage = findViewById(R.id.nextPage);
    }
}
