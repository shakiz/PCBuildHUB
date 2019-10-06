package com.shakil.pcbuildhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class PasswordResetVerificationActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset_verification);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        linearLayout.startAnimation(a);
        bindUIWIthComponents();
    }

    private void init() {
        linearLayout = findViewById(R.id.mainLayout);
    }

    private void bindUIWIthComponents(){
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PasswordResetVerificationActivity.this,ForgotPasswordActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}
