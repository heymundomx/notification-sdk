package com.heymundomx.push.sdkdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.heymundomx.push.sdk.provider.OneSignalPush;

public class ActivityDetails extends AppCompatActivity {

    Toolbar toolbar;
    TextView txtPostId;
    String uniqueId = "";
    String postId = "";
    String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (getIntent() != null) {
            uniqueId = getIntent().getStringExtra(OneSignalPush.EXTRA_UNIQUE_ID);
            postId = getIntent().getStringExtra(OneSignalPush.EXTRA_POST_ID);
            link = getIntent().getStringExtra(OneSignalPush.EXTRA_LINK);
        }
        initView();
        initToolbar();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        txtPostId = findViewById(R.id.txt_post_id);
        txtPostId.setText("Unique ID: " + uniqueId + "\nPost ID: " + postId + "\nLink: " + link);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.app_name));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}