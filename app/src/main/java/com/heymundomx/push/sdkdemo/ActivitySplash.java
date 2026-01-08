package com.heymundomx.push.sdkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ActivitySplash extends AppCompatActivity {

    RelativeLayout parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler(Looper.getMainLooper()).postDelayed(this::startMainActivity, 2500);

        parentView = findViewById(R.id.root_view);
        parentView.setBackgroundColor(ContextCompat.getColor(this, R.color.color_light_background));
    }

    private void startMainActivity() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}