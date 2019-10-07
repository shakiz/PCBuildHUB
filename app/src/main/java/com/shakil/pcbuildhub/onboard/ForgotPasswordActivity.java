package com.shakil.pcbuildhub.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.shakil.pcbuildhub.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        linearLayout.startAnimation(a);
        bindUIWIthComponents();
    }

    private void init() {
        linearLayout = findViewById(R.id.mainLayout);
        send = findViewById(R.id.send);
    }

    private void bindUIWIthComponents(){
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPasswordActivity.this,PasswordResetVerificationActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}
