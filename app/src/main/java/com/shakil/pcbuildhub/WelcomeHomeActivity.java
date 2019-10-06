package com.shakil.pcbuildhub;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeHomeActivity extends AppCompatActivity {

    private TextView loginTextView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_welcome);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        linearLayout.startAnimation(a);
        bindUIWIthComponents();
    }

    private void init() {
        loginTextView = findViewById(R.id.login);
        linearLayout = findViewById(R.id.mainLayout);
    }

    private void bindUIWIthComponents(){

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeHomeActivity.this, LoginActivity.class));
            }
        });
    }
}
