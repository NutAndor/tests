package com.gpl.rpg.AndorsTrail_beta.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Window;
import android.view.WindowManager;

import com.gpl.rpg.AndorsTrail_beta.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail_beta.R;
import com.gpl.rpg.AndorsTrail_beta.util.ThemeHelper;

public final class Preferences extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(ThemeHelper.getBaseTheme());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		AndorsTrailApplication app = AndorsTrailApplication.getApplicationFromActivity(this);
		if (app.getPreferences().fullscreen) {
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		} else {
			getWindow().setFlags(0, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}

		app.setLocale(this);
		addPreferencesFromResource(R.xml.preferences);
	}

	@Override
	protected void onResume() {
		super.onResume();
		AndorsTrailApplication app = AndorsTrailApplication.getApplicationFromActivity(this);
		app.setLocale(this);
	}
}

