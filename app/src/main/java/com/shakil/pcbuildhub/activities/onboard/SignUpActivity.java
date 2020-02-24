package com.shakil.pcbuildhub.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.roger.catloadinglibrary.CatLoadingView;
import com.shakil.pcbuildhub.R;

public class SignUpActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button SignUp;
    private CatLoadingView mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initUI();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        linearLayout.startAnimation(a);
        bindUIWithComponents();
    }

    private void initUI() {
        linearLayout = findViewById(R.id.mainLayout);
        SignUp = findViewById(R.id.SignUp);
        mView = new CatLoadingView();
    }

    private void bindUIWithComponents() {
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    public void showCustomDialog() {
        mView.show(getSupportFragmentManager(), "");
        mView.setCanceledOnTouchOutside(true);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
            }
        }, 1400);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }
}
