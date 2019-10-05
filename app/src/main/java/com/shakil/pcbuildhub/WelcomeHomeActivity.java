package com.shakil.pcbuildhub;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeHomeActivity extends AppCompatActivity {

    private TextView loginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_welcome);

        init();
        bindUIWIthComponents();
    }

    private void init() {
        loginTextView = findViewById(R.id.login);
    }

    private void bindUIWIthComponents(){
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeHomeActivity.this, LoginActivity.class));
            }
        });
    }
}
