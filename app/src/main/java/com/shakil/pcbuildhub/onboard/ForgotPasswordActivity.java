package com.shakil.pcbuildhub.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ActivityForgotPasswordBinding forgotPasswordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forgotPasswordBinding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        forgotPasswordBinding.mainLayout.startAnimation(a);
        bindUIWIthComponents();
    }

    private void init() {
    }

    private void bindUIWIthComponents(){
        forgotPasswordBinding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPasswordActivity.this,PasswordResetVerificationActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.push_up_out);
    }
}
