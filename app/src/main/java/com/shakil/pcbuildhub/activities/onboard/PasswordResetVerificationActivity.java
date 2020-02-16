package com.shakil.pcbuildhub.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import com.roger.catloadinglibrary.CatLoadingView;
import com.shakil.pcbuildhub.R;

public class PasswordResetVerificationActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private CatLoadingView mView;

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
        mView = new CatLoadingView();
    }

    private void bindUIWIthComponents(){
        Button verify = findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PasswordResetVerificationActivity.this,ForgotPasswordActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.push_up_out);
    }

    public void showCustomDialog() {
        mView.show(getSupportFragmentManager(), "");
        mView.setCanceledOnTouchOutside(true);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(PasswordResetVerificationActivity.this,HomeActivity.class));
            }
        }, 1400);
    }
}
