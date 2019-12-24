package com.shakil.pcbuildhub.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shakil.pcbuildhub.R;

public class WelcomeHomeActivity extends AppCompatActivity {

    private TextView loginTextView;
    private LinearLayout linearLayout;
    private Button startWithMobileBtn,startWithEmailBtn;

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
        startWithMobileBtn = findViewById(R.id.startWithMobile);
        startWithEmailBtn = findViewById(R.id.startWithEmail);
        linearLayout = findViewById(R.id.mainLayout);
    }

    private void bindUIWIthComponents(){

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeHomeActivity.this, LoginActivity.class));
            }
        });

        startWithMobileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeHomeActivity.this,StartWithMobileActivity.class));
            }
        });

        startWithEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeHomeActivity.this,StartWithEmailActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        exitApp();
    }

    public void exitApp(){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(exitIntent);
    }
}
