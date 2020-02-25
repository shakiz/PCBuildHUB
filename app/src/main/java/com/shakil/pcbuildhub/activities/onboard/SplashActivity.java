package com.shakil.pcbuildhub.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.shakil.pcbuildhub.R;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "Shakil-SplashActivity";
    private LinearLayout linearLayout;
    private SharedPreferences userPref;
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

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (userPref.getString("email",null) != null) {
                    startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                }
                else{
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    Log.e(TAG,"Pref null");
                }
            }
        }, 1400);

    }

    private void init() {
        linearLayout = findViewById(R.id.mainLayout);
        userPref = getSharedPreferences("user_details",MODE_PRIVATE);
    }
}
