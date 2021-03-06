package com.gpl.rpg.AndorsTrail_beta.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.gpl.rpg.AndorsTrail_beta.AndorsTrailApplication;

public abstract class AndorsTrailBaseFragmentActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndorsTrailApplication app = AndorsTrailApplication.getApplicationFromActivity(this);
        app.setLocale(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AndorsTrailApplication app = AndorsTrailApplication.getApplicationFromActivity(this);
        app.setLocale(this);
    }
}
