package com.shakil.pcbuildhub.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.roger.catloadinglibrary.CatLoadingView;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding loginBinding;
    private CatLoadingView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this , R.layout.activity_login);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        loginBinding.mainLayout.startAnimation(a);
        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
        loginBinding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
            }
        });

        loginBinding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });

        loginBinding.Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
    }

    private void init() {
        mView = new CatLoadingView();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LoginActivity.this,WelcomeHomeActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.push_up_out);
    }

    public void showCustomDialog() {
        mView.show(getSupportFragmentManager(), "");
        mView.setCanceledOnTouchOutside(true);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        }, 1400);
    }
}
