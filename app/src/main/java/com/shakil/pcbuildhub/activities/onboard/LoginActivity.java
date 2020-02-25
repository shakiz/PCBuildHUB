package com.shakil.pcbuildhub.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.roger.catloadinglibrary.CatLoadingView;
import com.shakil.pcbuildhub.R;
import com.shakil.pcbuildhub.databinding.ActivityLoginBinding;
import com.shakil.pcbuildhub.utils.UtilsForAll;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding loginBinding;
    private CatLoadingView mView;
    private SharedPreferences userPref;
    private SharedPreferences.Editor userEditor;

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
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void init() {
        userPref=getSharedPreferences("user_details",MODE_PRIVATE);
        userEditor=userPref.edit();
        mView = new CatLoadingView();
    }

    @Override
    public void onBackPressed() {
//        startActivity(new Intent(LoginActivity.this,WelcomeHomeActivity.class));
//        overridePendingTransition(R.anim.fadein,R.anim.push_up_out);
        UtilsForAll.exitApp(this);
    }

    public void showCustomDialog() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                makeAuth();
            }
        }, 1400);
    }


    private void makeAuth() {
        mView.show(getSupportFragmentManager(), "");
        mView.setCanceledOnTouchOutside(false);
        if (!loginBinding.Email.getText().toString().isEmpty() && !loginBinding.Password.getText().toString().isEmpty()){
            userEditor.putString("email",loginBinding.Email.getText().toString());
            userEditor.putString("type",loginBinding.Password.getText().toString());
            userEditor.commit();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        } else {
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.please_check_input),Toast.LENGTH_SHORT).show();
            mView.dismiss();
        }
    }
}
