package com.shakil.pcbuildhub.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.roger.catloadinglibrary.CatLoadingView;
import com.shakil.pcbuildhub.HomeActivity;
import com.shakil.pcbuildhub.R;

public class StartWithMobileActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button startBtn;
    private CatLoadingView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_with_mobile);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        linearLayout.startAnimation(a);
        bindUIWIthComponents();
    }

    private void init() {
        linearLayout = findViewById(R.id.mainLayout);
        startBtn = findViewById(R.id.start);
        mView = new CatLoadingView();
    }

    private void bindUIWIthComponents(){
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.show(getSupportFragmentManager(), "");
                mView.dismiss();
                startActivity(new Intent(StartWithMobileActivity.this, HomeActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(StartWithMobileActivity.this,WelcomeHomeActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}