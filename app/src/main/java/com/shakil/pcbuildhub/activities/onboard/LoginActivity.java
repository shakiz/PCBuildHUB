package com.shakil.pcbuildhub.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shakil.pcbuildhub.R;

public class LoginActivity extends AppCompatActivity {

    private TextView forgotPasswordTextView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        linearLayout.startAnimation(a);
        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
            }
        });
    }

    private void init() {
        forgotPasswordTextView = findViewById(R.id.forgotPassword);
        linearLayout = findViewById(R.id.mainLayout);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LoginActivity.this,WelcomeHomeActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.push_up_out);
    }
}
